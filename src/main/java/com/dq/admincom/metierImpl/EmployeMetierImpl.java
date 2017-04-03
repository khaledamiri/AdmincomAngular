package com.dq.admincom.metierImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dq.admincom.dao.EmployeeLangRepository;
import com.dq.admincom.dao.EmployeeRepository;
import com.dq.admincom.detail.EmployeeDetail;
import com.dq.admincom.entities.Employee;
import com.dq.admincom.entities.EmployeeLang;
import com.dq.admincom.metier.EmployeIMetier;

@Service
public class EmployeMetierImpl implements EmployeIMetier {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeLangRepository employeeLangRepository;

	public Employee createEmploye(EmployeeDetail employeDetail) {

		Employee employee = new Employee();
		employee.setJob(employeDetail.getJob());
		employee.setStatut(employeDetail.getStatut());
		employee.setUnit(employeDetail.getUnit());

		employeeRepository.save(employee);

		EmployeeLang employeeLang = new EmployeeLang();
		employeeLang.setEmployee(employee);
		employeeLang.setFullnameEmp(employeDetail.getFullnameEmp());
		employeeLang.setLangEmp(employeDetail.getLangEmp());
		employeeLang.setMatriculeEmp(employeDetail.getMatriculeEmp());
		employeeLangRepository.save(employeeLang);
		return employee;
	}

	public void deleteEmploye(String id) {

		employeeRepository.deleteEmployee(id);
		
	}

	@Override
	public List<Employee> findAllEmploye() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmploye(EmployeeDetail employeeUpdate) {
		Employee employee = findEmployeById(employeeUpdate.getIdEmployee());
		EmployeeLang employeeLang = findEmployeLangById(employeeUpdate.getIdEmpLang());
		if (employee != null) {
			employee.setJob(employeeUpdate.getJob());
			employee.setUnit(employeeUpdate.getUnit());
			employee.setStatut(employeeUpdate.getStatut());
			employeeRepository.save(employee);
			
			employeeLang.setEmployee(employee);
			employeeLang.setFullnameEmp(employeeUpdate.getFullnameEmp());
			employeeLang.setLangEmp(employeeUpdate.getLangEmp());
			employeeLang.setMatriculeEmp(employeeUpdate.getMatriculeEmp());
			employeeLangRepository.save(employeeLang);
			
			return employee;
		}

		return null;
	}

	@Override
	public Employee findEmployeById(String id) {

		return employeeRepository.findOne(id);
	}

	@Override
	public EmployeeLang createEmployeLang(EmployeeLang employeLang) {

		return employeeLangRepository.save(employeLang);
	}

	@Override
	public void deleteEmployeLang(String id) {
		employeeLangRepository.delete(id);

	}

	@Override
	public List<EmployeeLang> findAllEmployeLang(String langEmp) {

		return employeeLangRepository.findByLangEmp(langEmp);
	}

	@Override
	public EmployeeLang updateEmployeLang(EmployeeLang employeeUpdate) {
		EmployeeLang employee = findEmployeLangById(employeeUpdate
				.getIdEmpLang());

		if (employee != null) {
			employee.setFullnameEmp(employeeUpdate.getFullnameEmp());
			employee.setEmployee(employeeUpdate.getEmployee());
			employee.setLangEmp(employeeUpdate.getLangEmp());
			employee.setMatriculeEmp(employeeUpdate.getMatriculeEmp());

			employeeLangRepository.save(employee);

			return employee;
		}

		return null;
	}

	@Override
	public EmployeeLang findEmployeLangById(String id) {

		return employeeLangRepository.findOne(id);
	}

}
