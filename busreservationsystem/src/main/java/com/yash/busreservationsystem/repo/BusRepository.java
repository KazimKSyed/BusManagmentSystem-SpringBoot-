package com.yash.busreservationsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.busreservationsystem.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	List<Bus> findBySourceAndDestination(String source,String destination);
	

}
