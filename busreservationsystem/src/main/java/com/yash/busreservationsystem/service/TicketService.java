package com.yash.busreservationsystem.service;

import java.util.List;

import com.yash.busreservationsystem.entity.Bus;
import com.yash.busreservationsystem.entity.Ticket;
import com.yash.busreservationsystem.entity.User;

public interface TicketService {
	List<Ticket> getTicketbyCustId(int id);
	boolean saveTicket(User user,int busId,int seat);
	void displayTicket(Ticket ticket,User user,Bus bus);

}
