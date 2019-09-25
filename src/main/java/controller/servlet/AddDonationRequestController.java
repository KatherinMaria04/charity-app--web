package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AdminAccessController;
import com.revature.controller.AdminController;

/**
 * Servlet implementation class AddDonationRequestController
 */
@WebServlet("/AddDonationRequestController")
public class AddDonationRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //http://localhost:8080/Charity_app/AddDonationRequestController?requestType=B&amountRequested=1&targetAmount=10
	// From JSP,you need to call the above url and pass 3 inputs ( requestType,amountRequested,targetAmount)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get inputs
		
		long targetAmount = Long.parseLong(request.getParameter("targetAmount"));
		long amountRequested = Long.parseLong(request.getParameter("amountRequested"));
		String requestType = request.getParameter("requestType"); 
		
		
		//2. call controller
		AdminAccessController controller = new AdminAccessController();		
		String json = controller.donationsUpdate(requestType, amountRequested, targetAmount);
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}


}
