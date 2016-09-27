package com.loginapp.service;

import org.springframework.stereotype.Service;
import com.loginapp.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}


	public boolean checkLogin(String userName,String userPassword){
		return loginDAO.checkLogin(userName, userPassword);
	}
}
