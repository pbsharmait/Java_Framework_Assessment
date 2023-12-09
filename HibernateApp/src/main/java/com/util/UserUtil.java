package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.User;

public class UserUtil {
		public static Session  creatSession()
		{
			SessionFactory sf=new Configuration()
					.addAnnotatedClass(User.class)
					.configure()
					.buildSessionFactory();
			Session session=sf.openSession();
			return session;
		}
}
