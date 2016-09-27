package com.loginapp.dao;

import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;


@Repository("lognDAO")
public class LoginDAOImpl implements LoginDAO{
	
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkLogin(String userName,String userPassword){
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String SQL_QUERY = " from Users as o where o.userName=? and o.userPassword=?";
		Query query = session.createQuery(SQL_QUERY);
		System.out.println("0>>"+userName);
		System.out.println("1>>"+userPassword);
		query.setParameter(0, userName);
		query.setParameter(1, userPassword);
		List list = query.list();
		System.out.println("list size >>"+list.size());
		if((list!=null) && (list.size()>0)){
			userFound = true;
		}
		session.close();
		return userFound;
	}
	
	
	
	

}
