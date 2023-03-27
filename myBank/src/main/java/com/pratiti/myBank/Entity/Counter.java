package com.pratiti.myBank.Entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Counter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private int counterNo;
	
	@OneToMany(mappedBy = "counter", cascade = CascadeType.ALL)
	private List<Token> token;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="counter_service", joinColumns = @JoinColumn(name="c_id"),inverseJoinColumns = @JoinColumn(name="s_id"))
	private Set<BankService> service;
	
	
	
	
	
	
	public List<Token> getToken() {
		return token;
	}
	public void setToken(List<Token> token) {
		this.token = token;
	}

	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public Set<BankService> getService() {
		return service;
	}
	public void setService(Set<BankService> service) {
		this.service = service;
	}
	public int getCounterNo() {
		return counterNo;
	}
	public void setCounterNo(int counterNo) {
		this.counterNo = counterNo;
	}
	
	
	

}
