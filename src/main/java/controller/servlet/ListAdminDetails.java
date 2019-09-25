package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AdminController;

/**
 * Servlet implementation class ListAdminDetails
 */
@WebServlet("/ListAdminDetails")
public class ListAdminDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminController controller = new AdminController();
		String json = controller.requestDetails();
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}


}
