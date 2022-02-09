package com.webrixtec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webrixtec.model.billHistory;

@Repository
public interface billHistoryRepo extends JpaRepository<billHistory, Long> {

}
