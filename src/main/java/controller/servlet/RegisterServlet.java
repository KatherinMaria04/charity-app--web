package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.exception.DBException;
import com.revature.model.UserDetails;


/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String cus_name = request.getParameter("username");
	        String password = request.getParameter("password");
	        long phone_num = Long.parseLong(request.getParameter("phonenumber"));
	        
	        String json = LoginController.register(cus_name, password,phone_num);
	        PrintWriter out = response.getWriter();
	        out.write(json);        
	        out.flush();
	
			
			}
		
			
		
	    
		
			
	}

	


