package com.dq.admincom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dq.admincom.entities.EmployeeLang;

public interface EmployeeLangRepository extends JpaRepository<EmployeeLang, String> {

	List<EmployeeLang> findByLangEmp(String langEmp);
	
}
