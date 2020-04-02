package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.Date;

public class BankEmployeeVerifyAppointment {

	private BankClient bankClient;

	public void verifyAppointments(BankEmployee bankEmployee) {
		for (int i = 0; i < bankEmployee.bankClientsWithAppointments.size(); ++i) {

			Date date = bankEmployee.appointmentDates.get(i);
			this.bankClient = bankEmployee.bankClientsWithAppointments.get(i);

			System.out.println("\nCandidate date: " + date + " with Client: " + bankClient.name);

			System.out.println("1. Book it");
			System.out.println("2. Do not book it");
			String choice = Read.read("choice");

			while(!choice.equals("1")&&!choice.equals("2")) {
				System.out.println("Invalid, Enter Again");
				choice = Read.read("choice");
			}
			
			if (choice.equals("1")) {
				bookAppointment(date, bankEmployee.name); // we assume that we answer with this call to the
				// client.
				System.out.println("Appointment Date: " + date + "\tScheduled: " + true);
			} else if (choice.equals("2")) {
				System.out.println("Appointment Date: " + date + "\tScheduled: " + false);
			}

		}
	}
	
	public void bookAppointment(Date date, String employeeName) {

		if (date == null || employeeName == null)
			System.err.println("Error book appointment transaction");

		else {

			if (bankClient.appointments == null)
				bankClient.appointments = new ArrayList<Date>();

			bankClient.appointments.add(date);

			if (bankClient.bankEmployeesWithAppointments == null)
				bankClient.bankEmployeesWithAppointments = new ArrayList<String>();

			bankClient.bankEmployeesWithAppointments.add(employeeName);
		}
	}

}
