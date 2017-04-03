package com.dq.admincom.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the TRANSFERS database table.
 * 
 */
@Entity
@Table(name = "TRANSFERS")
@NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "TransfersGenerator")
	@GenericGenerator(name = "TransfersGenerator", strategy = "com.dq.admincom.identifiergenerator.TableKeyGenerator", parameters = {
			@Parameter(name = "key", value = "Transfers"),
			@Parameter(name = "prefixe", value = "TR-") }

	)
	@Column(name = "ID_TRANSFER")
	private String idTransfer;

	@Column(name = "DATE_JC_RECEIVE")
	private Date dateJcReceive;

	@Column(name = "DATE_SEND_JC_TRANSFER")
	private Date dateSendJcTransfer;

	@Column(name = "LAST_TRANS_SERIAL")
	private String lastTransSerial;

	@Column(name = "NUM_COPY")
	private String numCopy;

	private String subject;

	@Column(name = "TRANS_REC_SERIAL")
	private String transRecSerial;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "ID_EMPLOYEE")
	private Employee employee;

	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "UNIT_TRANS_TO")
	private Unit unit1;

	// bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name = "ID_UNIT")
	private Unit unit2;

	public Transfer() {
	}

	public Date getDateJcReceive() {
		return this.dateJcReceive;
	}

	public void setDateJcReceive(Date dateJcReceive) {
		this.dateJcReceive = dateJcReceive;
	}

	public Date getDateSendJcTransfer() {
		return this.dateSendJcTransfer;
	}

	public void setDateSendJcTransfer(Date dateSendJcTransfer) {
		this.dateSendJcTransfer = dateSendJcTransfer;
	}

	public String getIdTransfer() {
		return this.idTransfer;
	}

	public void setIdTransfer(String idTransfer) {
		this.idTransfer = idTransfer;
	}

	public String getLastTransSerial() {
		return this.lastTransSerial;
	}

	public void setLastTransSerial(String lastTransSerial) {
		this.lastTransSerial = lastTransSerial;
	}

	public String getNumCopy() {
		return this.numCopy;
	}

	public void setNumCopy(String numCopy) {
		this.numCopy = numCopy;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTransRecSerial() {
		return this.transRecSerial;
	}

	public void setTransRecSerial(String transRecSerial) {
		this.transRecSerial = transRecSerial;
	}

	@JsonIgnore
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@JsonIgnore
	public Unit getUnit1() {
		return this.unit1;
	}

	public void setUnit1(Unit unit1) {
		this.unit1 = unit1;
	}

	@JsonIgnore
	public Unit getUnit2() {
		return this.unit2;
	}

	public void setUnit2(Unit unit2) {
		this.unit2 = unit2;
	}

	@Override
	public String toString() {
		return "Transfer [idTransfer=" + idTransfer + ", dateJcReceive="
				+ dateJcReceive + ", dateSendJcTransfer=" + dateSendJcTransfer
				+ ", lastTransSerial=" + lastTransSerial + ", numCopy="
				+ numCopy + ", subject=" + subject + ", transRecSerial="
				+ transRecSerial + ", employee=" + employee + ", unit1="
				+ unit1 + ", unit2=" + unit2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateJcReceive == null) ? 0 : dateJcReceive.hashCode());
		result = prime
				* result
				+ ((dateSendJcTransfer == null) ? 0 : dateSendJcTransfer
						.hashCode());
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result
				+ ((idTransfer == null) ? 0 : idTransfer.hashCode());
		result = prime * result
				+ ((lastTransSerial == null) ? 0 : lastTransSerial.hashCode());
		result = prime * result + ((numCopy == null) ? 0 : numCopy.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((transRecSerial == null) ? 0 : transRecSerial.hashCode());
		result = prime * result + ((unit1 == null) ? 0 : unit1.hashCode());
		result = prime * result + ((unit2 == null) ? 0 : unit2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (dateJcReceive == null) {
			if (other.dateJcReceive != null)
				return false;
		} else if (!dateJcReceive.equals(other.dateJcReceive))
			return false;
		if (dateSendJcTransfer == null) {
			if (other.dateSendJcTransfer != null)
				return false;
		} else if (!dateSendJcTransfer.equals(other.dateSendJcTransfer))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (idTransfer == null) {
			if (other.idTransfer != null)
				return false;
		} else if (!idTransfer.equals(other.idTransfer))
			return false;
		if (lastTransSerial == null) {
			if (other.lastTransSerial != null)
				return false;
		} else if (!lastTransSerial.equals(other.lastTransSerial))
			return false;
		if (numCopy == null) {
			if (other.numCopy != null)
				return false;
		} else if (!numCopy.equals(other.numCopy))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (transRecSerial == null) {
			if (other.transRecSerial != null)
				return false;
		} else if (!transRecSerial.equals(other.transRecSerial))
			return false;
		if (unit1 == null) {
			if (other.unit1 != null)
				return false;
		} else if (!unit1.equals(other.unit1))
			return false;
		if (unit2 == null) {
			if (other.unit2 != null)
				return false;
		} else if (!unit2.equals(other.unit2))
			return false;
		return true;
	}

}