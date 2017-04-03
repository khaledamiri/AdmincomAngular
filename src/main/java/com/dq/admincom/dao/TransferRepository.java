package com.dq.admincom.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.dq.admincom.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, String> {

	@Query("SELECT t FROM Transfer t where t.dateSendJcTransfer >= :dateDebut and t.dateSendJcTransfer <= :dateFin and t.lastTransSerial=transRecSerial") 
	List<Transfer> findAllTransfer(@DateTimeFormat(iso = ISO.DATE)@Param("dateDebut") Date dateDebut,@DateTimeFormat(iso = ISO.DATE)@Param("dateFin")Date dateFin);
}
