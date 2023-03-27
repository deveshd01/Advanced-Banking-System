package com.pratiti.myBank.Entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Executive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int E_id;
	private String name;
	private String email;
	private String mob;
	private String Password;
	

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="executive_service", joinColumns = @JoinColumn(name="e_id"),inverseJoinColumns = @JoinColumn(name="s_id"))
	private Set<BankService> service;

	
	
	
	
	
	public String getMob() {
		return mob;
	}
	
	public void setMob(String mob) {
		this.mob = mob;
	}
	public int getE_id() {
		return E_id;
	}

	public void setE_id(int e_id) {
		E_id = e_id;
	}

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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Set<BankService> getService() {
		return service;
	}

	public void setService(Set<BankService> service) {
		this.service = service;
	}

}
