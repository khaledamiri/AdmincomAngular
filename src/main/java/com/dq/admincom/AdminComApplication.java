package com.dq.admincom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dq.admincom.entities.Transfer;
import com.dq.admincom.metier.EmployeIMetier;
import com.dq.admincom.metier.TransferIMetier;

@SpringBootApplication
public class AdminComApplication implements CommandLineRunner {

	@Autowired
	EmployeIMetier employeIMetier;
	@Autowired 
	TransferIMetier transferIMetier;

	public static void main(String[] args) {
		SpringApplication.run(AdminComApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		/*System.out.println("\n1.findAll()...");
		 for (Employee employee : employeIMetier.findAllEmploye()) {
		 System.out.println(employee.toString());
		 }

		System.out.println("\n2.findEmployeById(String id)...");

		Employee employee = employeIMetier
				.findEmployeById("EMP-00101090000577");
		System.out.println("numero" + employee.toString());

		System.out.println("\n2.AddEmployee...");
		Employee employee1 = new Employee();
		Job job = new Job();
		job.setIdJob("JO-3011006");

		Unit unit = new Unit();
		unit.setIdUnit("allorg");

		employee1.setJob(job);
		employee1.setUnit(unit);
		employee1.setStatut("1");

		Employee employeeCree = employeIMetier.createEmploye(employee1);

		System.out.println("numero" + employeeCree.toString());*/
		
		String dtD = "30-01-2017";  // Start date
		String dtF = "17-05-2017";  // End date
		SimpleDateFormat format =new SimpleDateFormat("dd-M-yyyy");
		Date dateDeb=format.parse(dtD);
		Date dateFin=format.parse(dtF);
//		c.setTime(format.parse(dt));
//		c.add(Calendar.DATE, 1);  // number of days to add
//		dt = format.format(c.getTime());  // dt is now the new date
		


		
		for (Transfer transfer : transferIMetier.findAllTransfer(dateDeb,dateFin)) {
			 System.out.println(transfer.toString());
			 }
		System.out.println("Done!");

	}
}
