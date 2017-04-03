package com.dq.admincom.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dq.admincom.entities.Transfer;
import com.dq.admincom.metier.TransferIMetier;

@RestController
public class TransferService {

	@Autowired
	TransferIMetier transferIMetier;

	@RequestMapping(value = { "/transfers" }, method = RequestMethod.GET)
	public List<Transfer> findAllTransfer(Date dateDebut, Date dateFin)
			throws ParseException {
		String dtD = "30-01-2017"; // Start date
		String dtF = "17-05-2017"; // End date
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy");
		Date dateDeb = format.parse(dtD);
		Date dateFinn = format.parse(dtF);
		return transferIMetier.findAllTransfer(dateDeb, dateFinn);
	}

}
