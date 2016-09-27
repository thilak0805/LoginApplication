package com.loginapp.service;
import java.util.List;

import com.loginapp.model.UserDetails;

public interface AddUserService {
	public boolean checkAddUsers(Integer userId,String userFirstName,String userLastName,String userAddress,String userMobile);
	
	public List<UserDetails> getUsers();

}
