package com.dq.admincom.detail;

import com.dq.admincom.entities.Employee;

public class EmployeeDetail extends Employee {

	private static final long serialVersionUID = 1L;

	private String idEmpLang;

	private String fullnameEmp;

	private String idEmployee;

	private String langEmp;

	private String matriculeEmp;

	public String getIdEmpLang() {
		return idEmpLang;
	}

	public void setIdEmpLang(String idEmpLang) {
		this.idEmpLang = idEmpLang;
	}

	public String getFullnameEmp() {
		return fullnameEmp;
	}

	public void setFullnameEmp(String fullnameEmp) {
		this.fullnameEmp = fullnameEmp;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getLangEmp() {
		return langEmp;
	}

	public void setLangEmp(String langEmp) {
		this.langEmp = langEmp;
	}

	public String getMatriculeEmp() {
		return matriculeEmp;
	}

	public void setMatriculeEmp(String matriculeEmp) {
		this.matriculeEmp = matriculeEmp;
	}

}
