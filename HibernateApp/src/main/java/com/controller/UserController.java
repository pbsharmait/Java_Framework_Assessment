package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			
			
			User u=new User();
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setEmail(request.getParameter("email"));
			u.setMobile(request.getParameter("mobile"));
			u.setAddress(request.getParameter("address"));
			u.setGender(request.getParameter("gender"));
			u.setPassword(request.getParameter("password"));
			UserDao.insertUser(u);
			response.sendRedirect("home.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		else if (action.equalsIgnoreCase("edit"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			User u=	UserDao.getUser(id);
			request.setAttribute("u", u);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("update"))
		{

			User u=new User();
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setEmail(request.getParameter("email"));
			u.setMobile(request.getParameter("mobile"));
			u.setAddress(request.getParameter("address"));
			u.setGender(request.getParameter("gender"));
			u.setPassword(request.getParameter("password"));
			UserDao.insertUser(u);
			response.sendRedirect("home.jsp");
		}
		
		else if (action.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			UserDao.deleteUser(id);
			response.sendRedirect("home.jsp");
		}
	}

}
