package com.intellizest.security.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intellizest.security.domain.IntelliUser;
import com.intellizest.security.util.UserUtil;

@Service("intelliUserDetailsService")
public class IntelliUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Inside loadUserByUsername : IntelliUserDetailService");
		
		IntelliUser intelliUser = UserUtil.getUser(username); // mocked here. fetch from repository in real scenario
		if(intelliUser == null)
			throw new UsernameNotFoundException("User not found with username "+username);
		
		System.out.println(intelliUser);
		
		return User.withUsername(intelliUser.getUserName())
					.password(intelliUser.getPassword())
					.roles(intelliUser.getRoles())
					.build();
	}
	
	
	

}
