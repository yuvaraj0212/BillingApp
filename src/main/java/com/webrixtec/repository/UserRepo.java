package com.webrixtec.repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.Role;
import com.webrixtec.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	User findByEmail(String email);



}
