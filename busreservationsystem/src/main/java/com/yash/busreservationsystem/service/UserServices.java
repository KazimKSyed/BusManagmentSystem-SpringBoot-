package com.yash.busreservationsystem.service;

import com.yash.busreservationsystem.entity.User;

public interface UserServices {
	boolean addUser(User user);
	User findUserByEmailAndPassword(String email,String password);
}
