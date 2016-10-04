package com.loginapp.dao;
import java.util.List;

import com.loginapp.model.UserDetails;

public interface AddUserDAO {
	public boolean checkAddUsers(Integer userId,String userFirstName,String userLastName,String userAddress,String userMobile);
	public List<UserDetails> getUsers();
	public UserDetails getPersonById(int id);
}
