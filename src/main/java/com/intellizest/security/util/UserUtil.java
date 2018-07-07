package com.intellizest.security.util;

import com.intellizest.security.domain.IntelliUser;

public class UserUtil {
	
	public static IntelliUser getUser(String userName) {
		IntelliUser user = new IntelliUser();
		user.setPassword("password");
		
		switch(userName) {
			case "user": { user.setUserName("user"); user.setRoles(new String[] {"USER"}); } break;
			case "admin": { user.setUserName("admin"); user.setPassword("admin");user.setRoles(new String[] {"ADMIN", "PROVIDER", "CONSUMER", "USER"}); } break;
			case "provider": { user.setUserName("provider"); user.setRoles(new String[] {"PROVIDER"}); } break;
			case "consumer": { user.setUserName("consumer"); user.setRoles(new String[] {"CONSUMER","USER"}); } break;
			default:
		}
		
		return user;
	}

}
