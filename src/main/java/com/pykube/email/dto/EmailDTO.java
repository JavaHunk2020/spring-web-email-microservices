package com.pykube.email.dto;

import java.util.List;

public class EmailDTO { 
	private String name;
	private String username;
	private List<String> toEmails;
	private String type;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getToEmails() {
		return toEmails;
	}

	public void setToEmails(List<String> toEmails) {
		this.toEmails = toEmails;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EmailDTO [toEmails=" + toEmails + ", type=" + type + "]";
	}

}
