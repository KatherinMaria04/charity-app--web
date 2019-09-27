package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;


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

	


