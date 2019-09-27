package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminController;

/**
 * Servlet implementation class DonorActivity
 */
@WebServlet("/DonorActivity")
public class DonorActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminController controller = new AdminController();
		String json = controller.findAll();
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	}




