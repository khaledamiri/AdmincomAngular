package com.dq.admincom.metierImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dq.admincom.dao.TransferRepository;
import com.dq.admincom.entities.Transfer;
import com.dq.admincom.metier.TransferIMetier;

@Service
public class TransferMetierImpl implements TransferIMetier {

	@Autowired
	TransferRepository transferRepository;

	@Override
	public List<Transfer> findAllTransfer(Date dateDebut,Date dateFin) {

		return transferRepository.findAllTransfer( dateDebut, dateFin);
	}

}
