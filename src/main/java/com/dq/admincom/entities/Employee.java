package com.dq.admincom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "EmployeeGenerator")
	@GenericGenerator(name = "EmployeeGenerator", strategy = "com.dq.admincom.identifiergenerator.TableKeyGenerator", parameters = {
			@Parameter(name = "key", value = "Employee"),
			@Parameter(name = "prefixe", value = "EM-") }

	)
	@Column(name = "ID_EMPLOYEE")
	private String idEmployee;

	private String statut;

	// bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name = "ID_JOB")
	private Job job;

	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "ID_UNIT")
	private Unit unit;

	// bi-directional many-to-one association to EmployeeLang
	@OneToMany(mappedBy = "employee",fetch=FetchType.LAZY)
	private List<EmployeeLang> employeeLangs;

	// bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy = "employee",fetch=FetchType.LAZY)
	private List<Transfer> transfers;

	public Employee() {
	}

	public String getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	@JsonIgnore
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	@JsonIgnore
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public List<EmployeeLang> getEmployeeLangs() {
		return this.employeeLangs;
	}

	public void setEmployeeLangs(List<EmployeeLang> employeeLangs) {
		this.employeeLangs = employeeLangs;
	}

	@JsonIgnore
	public List<Transfer> getTransfers() {
		return this.transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}




}