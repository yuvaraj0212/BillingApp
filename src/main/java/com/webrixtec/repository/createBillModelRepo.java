package com.webrixtec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.createBillModel;

@Repository
public interface createBillModelRepo extends JpaRepository<createBillModel, Long> {



}
