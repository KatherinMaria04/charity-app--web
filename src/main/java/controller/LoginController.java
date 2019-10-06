package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;

import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public class LoginController {
	 public static String login(String cusname, String password1) {
         
	        String errorMessage = null;
	         IUserDao user = new UserDao();
	         UserDetails ud= null;
	        try {
	            ud = user.login(cusname, password1);
	            if (ud == null) {
	            	throw new Exception("invalid");
	            }
	             
	        } catch (Exception e) {
	            //e.printStackTrace();
	            errorMessage = e.getMessage();
	        }       
	         
	        // Prepare JSON Object
	        String json = null;
	        Gson gson = new Gson();
	        if( ud != null) {
	             json = gson.toJson(ud);
	        }
	        else if ( ud == null ) {
	            JsonObject obj = new JsonObject();
	            obj.addProperty("errorMessage", errorMessage);
	            json = obj.toString();
	        }
	         
	         
	        return json;
	         
	    }
	 public static String register( String cus_name, String password, long phone_num)  {
         
	        String errorMessage = null;
	        String message = null;
	         IUserDao user = new UserDao();
	         UserDetails ud= null;
	        try {
	            ud=new UserDetails();
	            ud.setCustomername(cus_name);
	            ud.setPassword(password);
	            ud.setPhoneno(phone_num);
	            user.register(cus_name, password, phone_num);
	            message = "success";
	            }
	        
	             
	        catch (Exception e) {
	            //e.printStackTrace();
	            errorMessage = e.getMessage();
	        }       
	         
	        // Prepare JSON Object
	      
	 JsonObject obj = new JsonObject();
     if (message != null) {
         obj.addProperty("message", message);
     } else if (errorMessage != null) {
         obj.addProperty("errorMessage", errorMessage);
     }
     return obj.toString();
	         
	        
	         
	    }
	 public  String donarFund(String UserName, String RequestType , long DonatingAmount)
		{
			String json = null;
			String errorMessage = null;
			try {
				IUserDao ud=new UserDao();
				 UserActivity user = new UserActivity();
				 
				 user.setCustomername(UserName);;
				 user.setRequesttype(RequestType);
				 
				 user.setDonatingamount(DonatingAmount);;
				 
				ud.donarFund(user);
				ud.updateDonation(user);
			} catch (Exception e) {
				errorMessage = e.getMessage();
			}
			
			JsonObject obj = new JsonObject();
			if (errorMessage != null) {
				obj.addProperty("errorMessage", errorMessage);
			}
			else {
				obj.addProperty("message", "Successfully Updated");
			}
			
			json = obj.toString();
			
			return json;
		}
	     

	    public static void main(String[] args) {
	   //testLogin();
	    testRegister();
	    	//testDonarFund();
	    	
	    }
	    	
	    
	    	public static void testLogin() {
	         
	        System.out.println("Test Case 1: Valid User");
	        String validUserJson = LoginController.login("kathy", "123");
	        System.out.println(validUserJson);
	         
	        System.out.println("Test Case 2: Invalid User");
	        String invalidUserJson = LoginController.login("1123", "password");
	        System.out.println(invalidUserJson);
	    	}
	        
	        
	        public static void testRegister() {
		         
		        System.out.println("Test Case 1: Valid User");
		        String validUserJson = LoginController.register("priyanka", "234", 876543211l);
		        System.out.println(validUserJson);
		         
		        System.out.println("Test Case 2: Invalid User");
		        String invalidUserJson = LoginController.register("kathy", "123", 765432112l);
		        System.out.println(invalidUserJson);
	        }
	        
	        
		        public static void testDonarFund() {
			         
		        	LoginController controller = new LoginController();
		    		String json = controller.donarFund("kathy","medical",8000);
		    		System.out.println(json);
	         
	    }
	}


