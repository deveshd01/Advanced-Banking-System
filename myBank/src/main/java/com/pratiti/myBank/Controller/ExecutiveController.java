package com.pratiti.myBank.Controller;

import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pratiti.myBank.Entity.Executive;
import com.pratiti.myBank.Exception.MyException;
import com.pratiti.myBank.Model.ExecutiveModel;
import com.pratiti.myBank.Model.RequestStatus;
import com.pratiti.myBank.Service.ExecutiveService;


@RestController
@CrossOrigin
public class ExecutiveController {
	@Autowired
	private ExecutiveService executiveService;
	
	@PostMapping("/addExecutive")
	public RequestStatus addExecutive(@RequestBody ExecutiveModel executiveModel) {
		Executive executive = new Executive();
		BeanUtils.copyProperties(executiveModel, executive);

		
		Set<Integer> seviceIds = executiveModel.getServiceIds();
		
		
		RequestStatus status = new RequestStatus();
		try {
			int cId = executiveService.addExecutive(executive,seviceIds);
			status.setStatus(true);
			status.setMessage("Executive Added......!!!!!!");
			status.setId(cId);
		}
		catch(MyException e) {
			status.setStatus(false);
			status.setMessage(e.getMessage());
		}
		return status;
	}
	

}
