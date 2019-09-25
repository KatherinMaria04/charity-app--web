package controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonObject;
import com.revature.dao.AdminDao;
import com.revature.model.AdminAccess;

public class AdminAccessController {

	private AdminDao adminDao = new AdminDao();
	
	public  String donationsUpdate(String requestType, long amountRequested, long targetAmount)
	
	  {
		String json = null;
		String errorMessage = null;
		try {
			 AdminAccess admin = new AdminAccess();
			 admin.setRequesttype(requestType);
			 admin.setAmountrequested(amountRequested);
			 admin.setTargetamount(targetAmount);
			 
			adminDao.donationsUpdate(admin);
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
		AdminAccessController controller = new AdminAccessController();
		String json = controller.donationsUpdate("R",10,100);
		System.out.println(json);
	}
}
