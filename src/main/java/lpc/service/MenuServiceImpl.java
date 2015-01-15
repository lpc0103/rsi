package lpc.service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lpc.dao.CommonJdbcDaoUtils;
import lpc.dao.MenuDao;
import lpc.model.UapMenuResource;
import lpc.pageModel.MenuTreeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(MenuServiceImpl.class);

	
	
	MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<MenuTreeDTO> getMenu() {
		List<MenuTreeDTO> rmtd = new ArrayList<MenuTreeDTO>();
		try{
			StringBuffer first_menu_sql = new StringBuffer();
			first_menu_sql.setLength(0);
			first_menu_sql.append("select menuid,name,location ");
			first_menu_sql.append("  from uap_menu_resource a ");
			first_menu_sql.append(" where a.enable = :enable ");
			first_menu_sql.append("   and a.removed = :removed ");
			first_menu_sql.append("   and a.parentmenuid is null");
			first_menu_sql.append(" order by menuid");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("enable", 1);
			paramMap.put("removed", 0);
			List<UapMenuResource> firstMenu = CommonJdbcDaoUtils.queryForList(
					first_menu_sql.toString(), UapMenuResource.class, paramMap);
			rmtd = RM2TM(firstMenu);
			StringBuffer other_menu_sql = new StringBuffer();
			other_menu_sql.setLength(0);
			other_menu_sql.append("select menuid,parentmenuid,name,location ");
			other_menu_sql.append("  from uap_menu_resource a ");
			other_menu_sql.append(" where a.enable = :enable ");
			other_menu_sql.append("   and a.removed = :removed ");
			other_menu_sql.append("   and a.parentmenuid is not null");
			other_menu_sql.append(" order by parentmenuid,priority");
			List<UapMenuResource> otherMenu = CommonJdbcDaoUtils.queryForList(
					other_menu_sql.toString(), UapMenuResource.class, paramMap);
			
			rmtd = addOtherToFirst(rmtd,otherMenu);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return rmtd;
		
	}

	private List<MenuTreeDTO> RM2TM(List<UapMenuResource> rm){
		List<MenuTreeDTO> rmtd = new ArrayList<MenuTreeDTO>();
		if(rm != null && rm.size() > 0){
			MenuTreeDTO it = null;
			Map<String,String> att = null;
			for(UapMenuResource one :rm){
				it = new MenuTreeDTO();
				it.setId(one.getMenuid());
				it.setText(one.getName());
				if(!StringUtils.isNullOrEmpty(one.getLocation())){
					att = new HashMap<String,String>();
					att.put("url", one.getLocation());
					it.setAttributes(att);
					it.setState("closed");
				}
				rmtd.add(it);
			}
		}
		return rmtd;
	}
	
	private List<MenuTreeDTO> addOtherToFirst(List<MenuTreeDTO> first,List<UapMenuResource> otherMenu){
		if(first != null && first.size() > 0){
			MenuTreeDTO it = null;
			Map<String,String> att = null;
			String parentMenuid = null;
			Set<MenuTreeDTO> children = null;
			List<UapMenuResource> excep= null;
			for(MenuTreeDTO one :first){
				parentMenuid = one.getId();
				children = new HashSet<MenuTreeDTO>();
				excep = new ArrayList<UapMenuResource>();
				for(UapMenuResource other : otherMenu){
					if(other.getParentmenuid().equalsIgnoreCase(parentMenuid)){
						it = new MenuTreeDTO();
						it.setId(other.getMenuid());
						it.setText(other.getName());
						it.setState("open");
						if(!StringUtils.isNullOrEmpty(other.getLocation())){
							att = new HashMap<String,String>();
							att.put("url", other.getLocation());
							it.setAttributes(att);
						}
						excep.add(other);
						children.add(it);
					}
				}
				one.setChildren(children);
				otherMenu.removeAll(excep);
			}
		}
		return first;
	}
}
