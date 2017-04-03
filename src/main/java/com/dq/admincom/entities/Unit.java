package com.dq.admincom.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the UNIT database table.
 * 
 */
@Entity
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_UNIT")
	private String idUnit;

	@Column(name = "FAX_UNIT")
	private String faxUnit;

	private String statut;

	@Column(name = "TEL_UNIT")
	private String telUnit;

	// bi-directional many-to-one association to Employee
	@OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
	private List<Employee> employees;

	// bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy = "unit1", fetch = FetchType.LAZY)
	private List<Transfer> transfers1;

	// bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy = "unit2", fetch = FetchType.LAZY)
	private List<Transfer> transfers2;

	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "ID_PARENT_UNIT")
	private Unit unit;

	// bi-directional many-to-one association to Unit
	@OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
	private List<Unit> units;

	// bi-directional many-to-one association to UnitLang
	@OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
	private List<UnitLang> unitLangs;

	public Unit() {
	}

	public String getIdUnit() {
		return this.idUnit;
	}

	public void setIdUnit(String idUnit) {
		this.idUnit = idUnit;
	}

	public String getFaxUnit() {
		return this.faxUnit;
	}

	public void setFaxUnit(String faxUnit) {
		this.faxUnit = faxUnit;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTelUnit() {
		return this.telUnit;
	}

	public void setTelUnit(String telUnit) {
		this.telUnit = telUnit;
	}

	@JsonIgnore
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@JsonIgnore
	public List<Transfer> getTransfers1() {
		return this.transfers1;
	}

	public void setTransfers1(List<Transfer> transfers1) {
		this.transfers1 = transfers1;
	}

	@JsonIgnore
	public List<Transfer> getTransfers2() {
		return this.transfers2;
	}

	public void setTransfers2(List<Transfer> transfers2) {
		this.transfers2 = transfers2;
	}

	@JsonIgnore
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@JsonIgnore
	public List<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public List<UnitLang> getUnitLangs() {
		return this.unitLangs;
	}

	public void setUnitLangs(List<UnitLang> unitLangs) {
		this.unitLangs = unitLangs;
	}

}