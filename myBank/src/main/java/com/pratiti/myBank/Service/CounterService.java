package com.pratiti.myBank.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.myBank.Entity.BankService;
import com.pratiti.myBank.Entity.Counter;
import com.pratiti.myBank.Exception.MyException;
import com.pratiti.myBank.Repository.CounterRepo;
import com.pratiti.myBank.Repository.ServiceRepo;

@Service
public class CounterService {
	@Autowired
	private CounterRepo CounterRepo;
	
	@Autowired
	private ServiceRepo serviceRepo;

	
//	addCounter**********************************************************************************
	public int addCounter(Counter counter, Set<Integer> serviceIds) {

		if (!CounterRepo.existsByCounterNo(counter.getCounterNo())) {
			Set<BankService> serviceSet = new HashSet<>();
			for (Integer i : serviceIds) {
				BankService s = serviceRepo.findById(i).get();
				serviceSet.add(s);
			}
			
			counter.setService(serviceSet);
			CounterRepo.save(counter);
			return counter.getC_id();
		} else
			throw new MyException("Counter Already Exist");
	}

}
