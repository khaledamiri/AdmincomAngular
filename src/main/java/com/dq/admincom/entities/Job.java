package com.dq.admincom.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the JOB database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JOB")
	private String idJob;

	private String statut;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="job",fetch=FetchType.LAZY)
	private List<Employee> employees;

	//bi-directional many-to-one association to JobLang
	@OneToMany(mappedBy="job",fetch=FetchType.LAZY)
	private List<JobLang> jobLangs;

	public Job() {
	}

	public String getIdJob() {
		return this.idJob;
	}

	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}

	public List<JobLang> getJobLangs() {
		return this.jobLangs;
	}

	public void setJobLangs(List<JobLang> jobLangs) {
		this.jobLangs = jobLangs;
	}

	public JobLang addJobLang(JobLang jobLang) {
		getJobLangs().add(jobLang);
		jobLang.setJob(this);

		return jobLang;
	}

	public JobLang removeJobLang(JobLang jobLang) {
		getJobLangs().remove(jobLang);
		jobLang.setJob(null);

		return jobLang;
	}

}