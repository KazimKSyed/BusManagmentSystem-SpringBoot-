package com.yash.busreservationsystem.serviceimpl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.busreservationsystem.entity.Bus;
import com.yash.busreservationsystem.entity.User;
import com.yash.busreservationsystem.repo.BusRepository;
import com.yash.busreservationsystem.repo.UserRepository;
import com.yash.busreservationsystem.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepository userRepo;
@Autowired
private BusRepository busRepo;
	@Override
	public boolean addUser(User user) {
		try {
			System.out.println("Repo" + userRepo);
			userRepo.save(user);
			System.out.println("Registered Successfully...!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		try {
			User user = userRepo.findByEmailAndPassword(email, password);
		
			if (user != null) {
				System.out.println("Logged in Successfully...!");
				System.out.println("=============================Welcome To BRC===================================");
				if (user.getRole().equals("admin")) {
					System.out.println("1.Add Bus\n2.Get Bus\n3.get All buses\n4.update bus\n5.delete bus ");
					Scanner sc = new Scanner(System.in);
					int option = sc.nextInt();
					switch (option) {
					case 1: 
						System.out.println("Enter bus name:");
						String name=sc.next();
						System.out.println("Enter bus number:");
						String number=sc.next();
						System.out.println("Enter bus source:");
						String source=sc.next();
						System.out.println("Enter bus destination:");
						String destination=sc.next();
						System.out.println("Enter bus Type:");
						String busType=sc.next();
						System.out.println("Enter bus no Of Seats:");
						int noOfSeats=sc.nextInt();
						System.out.println("Enter bus fare:");
						int fare=sc.nextInt();;
						
						Bus bus=new Bus(name, number, source, destination, busType, noOfSeats, fare);
						
						busRepo.save(bus);
						break;
						
					case 2:

						break;
					case 3:

						break;

					default:
						break;
					}
				}
				return user;
			} else {
				System.out.println("Invalid Email And Password ");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
