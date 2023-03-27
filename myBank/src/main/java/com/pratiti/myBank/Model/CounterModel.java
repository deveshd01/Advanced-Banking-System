package com.pratiti.myBank.Model;

import java.util.Set;

public class CounterModel {
	private int counterNo;
	private Set<Integer> serviceIds;
	
	
	public int getCounterNo() {
		return counterNo;
	}
	public void setCounterNo(int counterNo) {
		this.counterNo = counterNo;
	}
	public Set<Integer> getServiceIds() {
		return serviceIds;
	}
	public void setServiceIds(Set<Integer> serviceIds) {
		this.serviceIds = serviceIds;
	}
	
	

}
