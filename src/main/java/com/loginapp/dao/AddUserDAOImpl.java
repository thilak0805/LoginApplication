package com.loginapp.dao;

import com.loginapp.dao.AddUserDAO;
import com.loginapp.form.UserForm;
import com.loginapp.model.UserDetails;

import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

@Repository
public class AddUserDAOImpl implements AddUserDAO{
	
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkAddUsers(Integer userId,String userFirstName,String userLastName,String userAddress,String userMobile) {
		Session session = sessionFactory.openSession();
		boolean recStatus = false;
		session.beginTransaction();
		try{
		System.out.println("in user dao...");
	/*	System.out.println("userId..."+userId);
		System.out.println("userfirstname >>> " +userFirstName);
		System.out.println("userLastName >>> " +userLastName);
		System.out.println("userAddress >>> " +userAddress);
		System.out.println("userMobile >>> " +userMobile);*/
		UserDetails userform = new UserDetails();
		userform.setUserId(1);
		userform.setUserFirstName(userFirstName);
		userform.setUserLastName(userLastName);
		userform.setUserAddress(userAddress);
		userform.setUserMobile(userMobile);
		
		session.save(userform);
		System.out.println("inserted ........"+userId);
		
	/*	String SQL_QUERY=" from UserDetails u where u.userId=?";
		
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userId);
		List list = query.list();
		System.out.println("list size 123>> " + list.size());
		if((list!=null) && (list.size()>0)){
			recStatus = true;
		}*/
		
		session.getTransaction().commit();
		session.close();
		recStatus=true;
		}catch(Exception e){
			e.printStackTrace();
			recStatus=false;
		}
		return recStatus;
	}
	
	public List<UserDetails> getUsers() {
		System.out.println("inside getusers().....");
		Session session = sessionFactory.openSession();
		boolean userListFound = false;
		String List_Query = " from UserDetails";
		Query query = session.createQuery(List_Query);
		List userList = query.list();
		System.out.println("userlist size>>>" + userList);
		
		if((userList!=null) && (userList.size()>0)){
			userListFound = true;
		}
		session.close();
		return userList;
	}

	public UserDetails getPersonById(int id) {
		Session session = sessionFactory.openSession();
		UserDetails u = (UserDetails)session.load(UserDetails.class, new Integer(id));
		return u;
	}

}
