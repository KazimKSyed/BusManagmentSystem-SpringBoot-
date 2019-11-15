package com.yash.busreservationsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.busreservationsystem.entity.Bus;
import com.yash.busreservationsystem.repo.BusRepository;
import com.yash.busreservationsystem.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusRepository busRepo;
	@Override
	public boolean addBus(Bus bus) {
		try {
			busRepo.save(bus);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Optional<Bus> getBusById(int id) {
		try {
			return busRepo.findById(id);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Bus> getAllBuses() {
		
		return null;
	}

	@Override
	public List<Bus> findBySourceAndDestination(String source, String destination) {
		try {
			return busRepo.findBySourceAndDestination(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
