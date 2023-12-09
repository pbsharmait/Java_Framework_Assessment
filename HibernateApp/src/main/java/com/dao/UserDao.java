package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {
	
	public static void insertUser(User u)
	{
		Session session=UserUtil.creatSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(u);
		tr.commit();
		session.close();
	}
	
	

	 public static List<User> getAllUser()
	 {
		 Session session=UserUtil.creatSession();
		 List<User> list=session.createQuery("from User").list();
		 session.close();
		 return list; 
	 }
	 public static User getUser(int id)
	 {
		 Session session=UserUtil.creatSession();
		 User u=session.get(User.class, id);
		 session.close();
		 return u;
	 }
	 public static void deleteUser(int id)
	 {
		 Session session=UserUtil.creatSession();
		 Transaction tr=session.beginTransaction();
		 
		 User u=session.get(User.class, id);
		 session.delete(u);
		 tr.commit();
		 session.close();
	 }
}
