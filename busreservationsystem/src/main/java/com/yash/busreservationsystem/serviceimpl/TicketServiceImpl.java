package com.yash.busreservationsystem.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.busreservationsystem.entity.Bus;
import com.yash.busreservationsystem.entity.Ticket;
import com.yash.busreservationsystem.entity.User;
import com.yash.busreservationsystem.repo.BusRepository;
import com.yash.busreservationsystem.repo.TicketRepo;
import com.yash.busreservationsystem.repo.UserRepository;
import com.yash.busreservationsystem.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<Ticket> getTicketbyCustId(int id) {
		return ticketRepo.findByCustId(id);
	}

	@Override
	public boolean saveTicket(User user,int busId,int seat) {
		try {
			Optional<Bus> bus=busRepo.findById(busId);
			Ticket ticket=new Ticket(busId, user.getId(), seat,bus.get().getSource(),bus.get().getDestination(), bus.get().getFare()*seat, LocalDate.now());
			ticketRepo.save(ticket);
			System.out.println("Congragulations your ticket is Booked....!");
			displayTicket(ticket,user,bus.get());
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void displayTicket(Ticket ticket,User user,Bus bus) {
		
		System.out.println("|------------------------------------------------------------------------------------------|");
		System.out.println("|                             ******* Yaari Travllers ****                                 |");
		System.out.println("|------------------------------------------------------------------------------------------|");
		System.out.println("|Bus From "+bus.getSource()+" To "+bus.getDestination()+"				  		"+"Booking Date : "+ticket.getBookingDate() +"  |");
		System.out.println("|------------------------------------------------------------------------------------------|");
		System.out.println("|\tJourny On |\tPassanger Name  |\tNo. of Seats |\tBus Name \t|Total Fare|");
		System.out.println("|------------------------------------------------------------------------------------------|");
		System.out.println("|\t"+ticket.getBookingDate()+"|\t"+user.getName()+"\t|\t"+ticket.getNoOfSeatBooked()+"\t     |"+bus.getName()+"("+
		bus.getBusType()+")"+"\t|"+bus.getFare()*ticket.getNoOfSeatBooked()+" Rs   |");
		System.out.println("|------------------------------------------------------------------------------------------|");
		System.out.println("Thank you...!");
		
	}

	
}
