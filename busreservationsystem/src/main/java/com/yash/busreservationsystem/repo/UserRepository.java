package com.yash.busreservationsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.busreservationsystem.entity.User;

@Repository()
public interface UserRepository extends JpaRepository<User, Integer> {
User findByEmailAndPassword(String mail,String password);
}
