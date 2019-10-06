package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminController;
import controller.LoginController;

/**
 * Servlet implementation class AmountUpdateServlet
 */
public class AmountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			 String requestType = request.getParameter("RequestType");
		        long amountRequested =Long.parseLong(request.getParameter("targetAmount"));
		        String json = AdminController.updateDonation( requestType,amountRequested);
		        PrintWriter out = response.getWriter();
		        out.write(json);        
		        out.flush();
		
	}

	

}
