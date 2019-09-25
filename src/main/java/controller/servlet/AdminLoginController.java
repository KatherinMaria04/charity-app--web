package com.revature.controller.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.dao.AdminDao;
import com.revature.dao.IAdminDao;
import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.model.AdminLogin;
import com.revature.model.UserDetails;

public class AdminLoginController {
	public static String adminLogin(String name, String password2) {
        
        String errorMessage = null;
         IAdminDao admin = new AdminDao();
         AdminLogin al= null;
        try {
           al = admin.adminLogin(name, password2);
            if (al == null) {
            	throw new Exception("invalid");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            errorMessage = e.getMessage();
        }       
         
        // Prepare JSON Object
        String json = null;
        Gson gson = new Gson();
        if( al != null) {
             json = gson.toJson(al);
        }
        else if ( al == null ) {
            JsonObject obj = new JsonObject();
            obj.addProperty("errorMessage", errorMessage);
            json = obj.toString();
        }
         
         
        return json;
         
    }
	
     
    public static void main(String[] args) {
         
        System.out.println("Test Case 1: Valid User");
        String validUserJson = AdminLoginController.adminLogin("admin", "admin");
        System.out.println(validUserJson);
         
        System.out.println("Test Case 2: Invalid User");
        String invalidUserJson = AdminLoginController.adminLogin("1123", "password");
        System.out.println(invalidUserJson);
         
    }
}

