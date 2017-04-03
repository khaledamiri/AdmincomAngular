package com.dq.admincom.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the UNIT_LANG database table.
 * 
 */
@Entity
@Table(name="UNIT_LANG")
@NamedQuery(name="UnitLang.findAll", query="SELECT u FROM UnitLang u")
public class UnitLang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_UNIT_LANG")
	private String idUnitLang;

	@Column(name="ADDRESS_UNIT")
	private String addressUnit;

	@Column(name="LANG_UNIT")
	private String langUnit;

	@Column(name="NAME_UNIT")
	private String nameUnit;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="ID_UNIT")
	private Unit unit;

	public UnitLang() {
	}

	public String getIdUnitLang() {
		return this.idUnitLang;
	}

	public void setIdUnitLang(String idUnitLang) {
		this.idUnitLang = idUnitLang;
	}

	public String getAddressUnit() {
		return this.addressUnit;
	}

	public void setAddressUnit(String addressUnit) {
		this.addressUnit = addressUnit;
	}

	public String getLangUnit() {
		return this.langUnit;
	}

	public void setLangUnit(String langUnit) {
		this.langUnit = langUnit;
	}

	public String getNameUnit() {
		return this.nameUnit;
	}

	public void setNameUnit(String nameUnit) {
		this.nameUnit = nameUnit;
	}
	@JsonIgnore
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}