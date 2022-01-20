package com.webrixtec.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webrixtec.model.Role;

public interface roleRepo extends JpaRepository<Role, Long>{

	Set<Role> findByRoleName(String string);

}
