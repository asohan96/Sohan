package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {
	private HashMap<String,String> users=new HashMap<>();
	public InMemoryLoginService() {
		users.put("sohan","123");
		users.put("tanuja","222");
		users.put("rohan","333");
				
	}
	public boolean isValidUser(String username,String password)
{	
		if(users.containsKey(username) && users.get(username).equals(password))
		
		return true;
else
	return false;
	
	
}
}
