package com.dq.admincom.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the EMPLOYEE_LANG database table.
 * 
 */
@Entity
@Table(name = "EMPLOYEE_LANG")
@NamedQuery(name = "EmployeeLang.findAll", query = "SELECT e FROM EmployeeLang e")
public class EmployeeLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "EmployeeLangGenerator")
	@GenericGenerator(name = "EmployeeLangGenerator", strategy = "com.dq.admincom.identifiergenerator.TableKeyGenerator", parameters = {
			@Parameter(name = "key", value = "EmployeeLang"),
			@Parameter(name = "prefixe", value = "EML-") }

	)
	@Column(name = "ID_EMP_LANG")
	private String idEmpLang;

	@Column(name = "FULLNAME_EMP")
	private String fullnameEmp;

	@Column(name = "LANG_EMP")
	private String langEmp;

	@Column(name = "MATRICULE_EMP")
	private String matriculeEmp;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "ID_EMPLOYEE")
	private Employee employee;

	public EmployeeLang() {
	}

	public String getIdEmpLang() {
		return this.idEmpLang;
	}

	public void setIdEmpLang(String idEmpLang) {
		this.idEmpLang = idEmpLang;
	}

	public String getFullnameEmp() {
		return this.fullnameEmp;
	}

	public void setFullnameEmp(String fullnameEmp) {
		this.fullnameEmp = fullnameEmp;
	}

	public String getLangEmp() {
		return this.langEmp;
	}

	public void setLangEmp(String langEmp) {
		this.langEmp = langEmp;
	}

	public String getMatriculeEmp() {
		return this.matriculeEmp;
	}

	public void setMatriculeEmp(String matriculeEmp) {
		this.matriculeEmp = matriculeEmp;
	}

	@JsonIgnore
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}