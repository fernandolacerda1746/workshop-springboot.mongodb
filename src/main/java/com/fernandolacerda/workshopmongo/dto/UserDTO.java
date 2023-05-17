package com.fernandolacerda.workshopmongo.dto;

import java.io.Serializable;

import com.fernandolacerda.workshopmongo.domain.User;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String user;
	private String email;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		
		id = obj.getId();
		user = obj.getUser();
		email = obj.getEmail();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		
		this.id = id;
		
	}

	public String getUser() {
		
		return user;
		
	}

	public void setUser(String user) {
		
		this.user = user;
		
	}

	public String getEmail() {
		
		return email;
		
	}

	public void setEmail(String email) {
		
		this.email = email;
		
	}

}
