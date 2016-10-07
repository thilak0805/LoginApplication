package com.loginapp.service;

import com.loginapp.dao.AddUserDAO;
import com.loginapp.model.UserDetails;
import com.loginapp.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Repository;

@Service
public class AddUserServiceImpl implements AddUserService{
	
	@Autowired
	private AddUserDAO adduserdao;
	
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void setAdduserdao(AddUserDAO adduserdao) {
		this.adduserdao = adduserdao;
	}



	public boolean checkAddUsers(Integer userId,String userFirstName,String userLastName,String userAddress,String userMobile) {
		return adduserdao.checkAddUsers(userId,userFirstName,userLastName,userAddress,userMobile);
	}

	
	public List<UserDetails> getUsers(){
		return adduserdao.getUsers();
	}



	public UserDetails getPersonById(int id) {
		return adduserdao.getPersonById(id);
	}



	public boolean updateUsersById(Integer userId,String userFirstName,String userLastName,String userAddress,String userMobile) {
		System.out.println("inside serviceimpl....");
		return adduserdao.updateUsersById(userId,userFirstName,userLastName,userAddress,userMobile);
	}

	







}
