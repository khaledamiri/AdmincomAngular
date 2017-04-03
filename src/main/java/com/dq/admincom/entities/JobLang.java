package com.dq.admincom.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the JOB_LANG database table.
 * 
 */
@Entity
@Table(name="JOB_LANG")
@NamedQuery(name="JobLang.findAll", query="SELECT j FROM JobLang j")
public class JobLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JOB_LANG")
	private String idJobLang;

	@Column(name="ABRV_JOB")
	private String abrvJob;

	@Column(name="LANG_JOB")
	private String langJob;

	@Column(name="LBL_JOB")
	private String lblJob;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="ID_JOB")
	private Job job;

	public JobLang() {
	}

	public String getIdJobLang() {
		return this.idJobLang;
	}

	public void setIdJobLang(String idJobLang) {
		this.idJobLang = idJobLang;
	}

	public String getAbrvJob() {
		return this.abrvJob;
	}

	public void setAbrvJob(String abrvJob) {
		this.abrvJob = abrvJob;
	}

	public String getLangJob() {
		return this.langJob;
	}

	public void setLangJob(String langJob) {
		this.langJob = langJob;
	}

	public String getLblJob() {
		return this.lblJob;
	}

	public void setLblJob(String lblJob) {
		this.lblJob = lblJob;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}