package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AdminAccessController;

/**
 * Servlet implementation class DonarFund
 */
@WebServlet("/DonarFund")
public class DonarFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserName = request.getParameter("UserName"); 
		String RequestType = request.getParameter("RequestType"); 
		long DonatingAmount = Long.parseLong(request.getParameter("DonatingAmount"));
		
		
		LoginController controller = new LoginController();		
		String json = controller.donarFund(UserName,RequestType,DonatingAmount);
		
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	}


