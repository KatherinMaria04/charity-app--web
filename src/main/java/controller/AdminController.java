package com.revature.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.dao.AdminDao;
import com.revature.dao.UserDao;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public class AdminController {

	private AdminDao adminDao = new AdminDao();
	
	/**
	 * For all DAO methods, first write a method in controller like the below.
	 * For Success, return some json
	 * For Error, return errorMessage as json
	 * Test the below methods using main method and verify json.
	 * Servet would be easy if you write json formation in controller methods 
	 */
	
	public  String requestDetails(){
		
		String json = null;
		List<AdminAccess> requestDetails = null;
		String errorMessage = null;
		try {
			requestDetails = adminDao.requestDetails();
		} catch (SQLException e) {
			errorMessage = e.getMessage();
		}
		
		//Convert list to json
		if ( requestDetails != null) {
			Gson gson = new Gson();
			json = gson.toJson(requestDetails);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
	}
	
	public  String donarDetails(){
		String json = null;
		 List<UserDetails>donarDetails  = null;
		String errorMessage = null;
		try {
			donarDetails = adminDao.donarDetails();
		} catch (SQLException e) {
			errorMessage = e.getMessage();
		}
		
		//Convert list to json
		if ( donarDetails != null) {
			Gson gson = new Gson();
			json = gson.toJson(donarDetails);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
		
	}
	
	public  String findAll(){
		String json = null;
		 List<UserActivity> findAll  = null;
		String errorMessage = null;
		try {
			findAll = adminDao.findAll();
		} catch (SQLException e) {
			errorMessage = e.getMessage();
		}
		
		//Convert list to json
		if ( findAll != null) {
			Gson gson = new Gson();
			json = gson.toJson(findAll);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
		
	}
	
       
        
	public static void main(String[] args) {
		//testrequestDetails();
		//testdonarDetails();
		testfindAll();
	}
		
		public static void testrequestDetails() {
		
		AdminController controller = new AdminController();
		String json = controller.requestDetails();
		System.out.println(json);
	}
		
		public static void testdonarDetails() {
			
			AdminController controller = new AdminController();
			String json = controller.donarDetails();
			System.out.println(json);
		}
		
		public static void testfindAll() {
			AdminController controller = new AdminController();
			String json = controller.findAll();
			System.out.println(json);
		}
}
	
