package com.dq.admincom.metier;

import java.util.Date;
import java.util.List;

import com.dq.admincom.entities.Transfer;

public interface TransferIMetier {

	public List<Transfer> findAllTransfer(Date dateDebut,Date dateFin);
}
