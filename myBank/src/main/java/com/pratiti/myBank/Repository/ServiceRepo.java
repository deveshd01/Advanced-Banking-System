package com.pratiti.myBank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.myBank.Entity.BankService;

public interface ServiceRepo extends JpaRepository<BankService, Integer> {

	boolean existsByServiceName(String serviceName);

	Optional<BankService> findByServiceName(String serviceName);
	

}
