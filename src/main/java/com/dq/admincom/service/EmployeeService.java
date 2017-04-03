package com.dq.admincom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dq.admincom.detail.EmployeeDetail;
import com.dq.admincom.entities.Employee;
import com.dq.admincom.entities.EmployeeLang;
import com.dq.admincom.metier.EmployeIMetier;

@RestController
public class EmployeeService {

	@Autowired
	EmployeIMetier employeIMetier;

	@RequestMapping(value = { "/createEmploye" }, method = RequestMethod.POST,consumes = "application/json")
	public void createEmploye(@RequestBody EmployeeDetail employe) {
		employeIMetier.createEmploye(employe);
	}

	@RequestMapping(value = "/deleteEmploye/{id}", method = RequestMethod.PUT)
	public void deleteEmploye(@PathVariable String id) {
		employeIMetier.deleteEmploye(id);
	}

	@RequestMapping(value = { "/findAllEmploye" }, method = RequestMethod.GET)
	public List<Employee> findAllEmploye() {
		return employeIMetier.findAllEmploye();
	}

	@RequestMapping(value = { "/updateEmploye" }, method = RequestMethod.PUT,consumes = "application/json")
	public void updateEmploye(@RequestBody EmployeeDetail employe) {
		employeIMetier.updateEmploye(employe);
	}

	
	
	
	
	
	
	
	@RequestMapping(value = { "/findEmployeById/{id}" }, method = RequestMethod.GET)
	public Employee findEmployeById(@PathVariable String id) {
		return employeIMetier.findEmployeById(id);
	}

	@RequestMapping(value = { "/createEmployeLang" }, method = RequestMethod.POST)
	public void createEmployeLang(@RequestBody EmployeeLang employeLang) {
		employeIMetier.createEmployeLang(employeLang);
	}

	@RequestMapping(value = "/deleteEmployeLang/{id}", method = RequestMethod.DELETE)
	public void deleteEmployeLang(@PathVariable String id) {
		employeIMetier.deleteEmployeLang(id);
	}

	@RequestMapping(value = { "/findAllEmployeLang/{id}" }, method = RequestMethod.GET)
	public List<EmployeeLang> findAllEmployeLang(@PathVariable String langEmp) {
		return employeIMetier.findAllEmployeLang(langEmp);
	}

	@RequestMapping(value = { "/updateEmployeLang" }, method = RequestMethod.PUT)
	public void updateEmployeLang(@RequestBody EmployeeLang employeLang) {
		employeIMetier.updateEmployeLang(employeLang);
	}

	@RequestMapping(value = { "/findEmployeLangById/{id}" }, method = RequestMethod.GET)
	public void findEmployeLangById(@PathVariable String id) {
		employeIMetier.findEmployeLangById(id);
	}

}
