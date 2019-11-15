package com.yash;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.busreservationsystem.entity.Bus;
import com.yash.busreservationsystem.entity.User;
import com.yash.busreservationsystem.serviceimpl.BusServiceImpl;
import com.yash.busreservationsystem.serviceimpl.TicketServiceImpl;
import com.yash.busreservationsystem.serviceimpl.UserServiceImpl;

@SpringBootApplication
public class BusreservationsystemApplication implements CommandLineRunner {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	BusServiceImpl busService;
	
	@Autowired
	TicketServiceImpl ticketService;

	public static void main(String[] args) {
		SpringApplication.run(BusreservationsystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		User loggedUser=null;
		System.out.println(
				"=============================================================================================== ");
		System.out.println(
				"                                      $ Welcome To BRS $                                                       ");
		System.out.println(
				"================================================================================================ ");
		while (true) {
			
			System.out.println("***** Choose The Options ******");
			System.out.println("1. New User Registration\n2. Log In\n3. Book Ticket");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the Email Id");
				String email = sc.next();
				System.out.println("Enter the mobile Number ");
				String mobile = sc.next();
				System.out.println("Enter the gender ");
				String gender = sc.next();
				System.out.println("Enter the Password ");
				String password = sc.next();
				String role="Customer";
				User user = new User(name, email, mobile, gender, password,role);
				
				userService.addUser(user);
				break;
			case 2:
				System.out.println("Enter Email --");
				String mail = sc.next();
				System.out.println("Enter Password --");
				String pass = sc.next();

				loggedUser=userService.findUserByEmailAndPassword(mail, pass);
			    
			    
				break;
			case 3:
				
				System.out.println("Source--->>\n~Pune\n~Mumbai\n~Nagpur\n~Pusad\n~Yavatmal\n~Latur ");
				System.out.println("Please Enter Source ");
				String source=sc.next();
				System.out.println("Destinations--->>\n~Pune\n~Mumbai\n~Nagpur\n~Pusad\n~Yavatmal\n~Latur ");
				System.out.println("Please Enter Destination ");
				String destination=sc.next();
				List<Bus> buses=busService.findBySourceAndDestination(source, destination);
				System.out.println("Available Buses are ===>>");
				for (Bus bus : buses) {
					System.out.println("Bus Id: "+bus.getId() +"\tBus Name: "+bus.getName()+"\tBus No: "+bus.getNumber()+"\tSeats Availables: "+bus.getNoOfSeatsAvailable()
					+"\tFare: "+bus.getFare()+" Rs");
				}
				System.out.println("Enter Bus Id to book :");
				int busId=sc.nextInt();
				System.out.println("Enter No of Seat to Book:");
				int seats=sc.nextInt();
			
		       ticketService.saveTicket(loggedUser, busId,seats);
				
				break;

			default:
				break;
			}
		}
	}

}
