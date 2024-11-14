package com.pharmassist.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pharmassist.entity.Admin;

@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails{
	
	
	
	private final Admin admin;
	

	
	

	public UserDetailsImpl(Admin admin) {
		super();
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return admin.getEmail();
	}

}
