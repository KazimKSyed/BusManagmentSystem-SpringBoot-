package com.yash.busreservationsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.busreservationsystem.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Integer> {
List<Ticket> findByCustId(int id);
}
