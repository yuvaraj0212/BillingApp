package com.webrixtec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.purhaseModel;

@Repository
public interface purchaseRepo extends JpaRepository<purhaseModel, Long> {

}
