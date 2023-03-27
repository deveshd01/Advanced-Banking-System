package com.pratiti.myBank.Service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratiti.myBank.Entity.BankService;
import com.pratiti.myBank.Entity.Executive;
import com.pratiti.myBank.Repository.ExecutiveRepo;
import com.pratiti.myBank.Repository.ServiceRepo;

@Service
public class ExecutiveService {
	@Autowired
	private ExecutiveRepo executiveRepo;

	@Autowired
	private ServiceRepo serviceRepo;

//	@Autowired
//	private ServiceService serviceService;

//	addExecutive
//	public int addExecutive(Executive executive, Set<BankService> services) {
//		Set<BankService> serviceSet = new HashSet<>();
//		for(BankService s : services) {
//			try {
//				serviceService.addService(s);
//				serviceSet.add(s);
//			} catch (Exception e) {	
//				// If Service Already present then Fetch that Service & add it to serviceSet
//				BankService s2 = serviceRepo.findByServiceName(s.getServiceName()).get();
//				serviceSet.add(s2);
//			}
//		}
//		executive.setService(serviceSet);
//		executiveRepo.save(executive);
//		return executive.getE_id();
//	}

	public int addExecutive(Executive executive, Set<Integer> serviceIds) {
		Set<BankService> serviceSet = new HashSet<>();
		for (Integer i : serviceIds) {
			BankService s = serviceRepo.findById(i).get();
			serviceSet.add(s);
		}
		executive.setService(serviceSet);
		executiveRepo.save(executive);
		return executive.getE_id();
	}

}
