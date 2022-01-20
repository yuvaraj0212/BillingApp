package com.webrixtec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.purchaseModel;

@Repository
public interface purchaseRepo extends JpaRepository<purchaseModel, Long> {


	Boolean existsByProductCode(String string);

	Boolean existsByProductName(String productName);

}
