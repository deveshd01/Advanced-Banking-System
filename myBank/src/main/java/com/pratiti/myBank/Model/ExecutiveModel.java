package com.pratiti.myBank.Model;

import java.util.Set;

public class ExecutiveModel {

	private String name;
	private String email;
	private String mob;
	private String Password;
	
	private Set<Integer> serviceIds;
	
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set<Integer> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(Set<Integer> serviceIds) {
		this.serviceIds = serviceIds;
	}



	

}
