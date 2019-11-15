package com.yash.busreservationsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yash.busreservationsystem.entity.Bus;

@Service
public interface BusService {

	boolean addBus(Bus bus);
	Optional<Bus> getBusById(int id);
	List<Bus> getAllBuses();
	List<Bus> findBySourceAndDestination(String source,String destination);
	
	
}
