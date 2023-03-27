package com.pratiti.myBank.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.myBank.Entity.BankService;
import com.pratiti.myBank.Exception.MyException;
import com.pratiti.myBank.Repository.ServiceRepo;

@Service
public class ServiceService {
	
	@Autowired
	private ServiceRepo serviceRepo;
	
	public int addService(BankService service) {
		if (!serviceRepo.existsByServiceName(service.getServiceName())) {
			serviceRepo.save(service);
			return service.getS_id();
		} else
			throw new MyException("Service Already Exist");
	}

	public List<BankService> findAll() {
		List<BankService> services = new ArrayList<>();
		services = serviceRepo.findAll();
		return services;
	}
}
