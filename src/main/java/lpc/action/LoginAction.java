package lpc.action;

import java.util.ArrayList;
import java.util.List;

import lpc.pageModel.MenuTreeDTO;
import lpc.pageModel.UserDTO;
import lpc.service.MenuService;
import lpc.service.UserService;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/loginAction")
public class LoginAction extends BaseAction implements ModelDriven<UserDTO>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private MenuService menuService;
	private UserDTO userDTO = new UserDTO();
	
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public MenuService getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	public UserDTO getModel() {
		// TODO Auto-generated method stub
		return userDTO;
	}
	
	@Action(value="login", results={@Result(name = "sucess", location = "/index.jsp")})
	public String login(){
		UserDTO r = new UserDTO();
		r.setResult("success");
		r.setReturn_msg("登录成功");
		getMenu();
		return "sucess";
	}
	
	public void getMenu(){
		List<MenuTreeDTO>  menuTree = new  ArrayList<MenuTreeDTO>();
		menuTree = menuService.getMenu();
		String menuJson = JSON.toJSONString(menuTree);
		this.getRequest().setAttribute("MenuJson", menuJson);
	}
	
}
