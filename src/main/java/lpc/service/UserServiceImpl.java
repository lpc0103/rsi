package lpc.service;

import lpc.dao.UserDao;
import lpc.model.UapUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public void saveUser() {
		UapUser user = new UapUser();
		user.setUserid(Integer.parseInt("1"));
		user.setLoginname("LIUPENGCHENG");
		user.setPassword("111111");
		user.setName("刘鹏程");
		user.setEnable("1");
		user.setRemoved("0");
		userDao.save(user);
		
		//Map<String,Object> param = new HashMap<String,Object>();
		//List<UapUser> list = CommonJdbcDaoUtils.queryForList("", UapUser.class, param);
	}


	

}
