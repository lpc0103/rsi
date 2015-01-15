package lpc.action.p60010101;
import lpc.action.BaseAction;
import lpc.pageModel.UserDTO;
import lpc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;



public class c60010101Action extends BaseAction implements ModelDriven<UserDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDTO user = new UserDTO();
	
	@Override
	public UserDTO getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void addUser(){
		
	}
	

}
