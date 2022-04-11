package com.webrixtec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.Products;
import com.webrixtec.model.User;


@Repository
public interface stockProductRepo extends JpaRepository<Products, Long> {

	
	
	
	
}
