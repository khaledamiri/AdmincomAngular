package com.dq.admincom.metier;

import java.util.List;

import com.dq.admincom.detail.EmployeeDetail;
import com.dq.admincom.entities.Employee;
import com.dq.admincom.entities.EmployeeLang;

public interface EmployeIMetier {

	public Employee createEmploye(EmployeeDetail employe);

	public void deleteEmploye(String id);

	public List<Employee> findAllEmploye();

	public Employee updateEmploye(EmployeeDetail employe);

	public Employee findEmployeById(String id);

	public EmployeeLang createEmployeLang(EmployeeLang employeLang);

	public void deleteEmployeLang(String id);

	public List<EmployeeLang> findAllEmployeLang(String langEmp);

	public EmployeeLang updateEmployeLang(EmployeeLang employeLang);

	public EmployeeLang findEmployeLangById(String id);

}
