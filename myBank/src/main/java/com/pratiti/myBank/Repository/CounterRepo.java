package com.pratiti.myBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.myBank.Entity.Counter;

public interface CounterRepo extends JpaRepository<Counter, Integer> {

	boolean existsByCounterNo(int counterNo);

	
	

}
