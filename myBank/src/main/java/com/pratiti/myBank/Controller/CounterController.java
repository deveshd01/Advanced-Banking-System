package com.pratiti.myBank.Controller;

import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.myBank.Entity.Counter;
import com.pratiti.myBank.Entity.Executive;
import com.pratiti.myBank.Exception.MyException;
import com.pratiti.myBank.Model.CounterModel;
import com.pratiti.myBank.Model.RequestStatus;
import com.pratiti.myBank.Service.CounterService;


@RestController
@CrossOrigin
public class CounterController {
	@Autowired
	private CounterService CounterService;
	
	@PostMapping("/addCounter")
	public RequestStatus addCounter(@RequestBody CounterModel counterModel) {
		Counter counter = new Counter();
		BeanUtils.copyProperties(counterModel, counter);
		
		Set<Integer> serviceIds = counterModel.getServiceIds();
		
		RequestStatus status = new RequestStatus();
		try {
			int cId = CounterService.addCounter(counter,serviceIds);
			status.setStatus(true);
			status.setMessage("Counter Added......!!!!!!");
			status.setId(cId);
		}
		catch(MyException e) {
			status.setStatus(false);
			status.setMessage(e.getMessage());
		}
		return status;
	}
	

}
