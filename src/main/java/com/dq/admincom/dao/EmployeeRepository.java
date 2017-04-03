package com.dq.admincom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dq.admincom.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Modifying(clearAutomatically = true)
	@Query("update Employee e set e.statut = '0' where e.idEmployee = ?1")
	@Transactional
	void deleteEmployee(@Param(value = "id") String id);
}
