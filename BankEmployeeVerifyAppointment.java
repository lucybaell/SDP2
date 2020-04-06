package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.Date;

/**
 * classes with methods to schedule appointments
 *
 */
public class BankEmployeeVerifyAppointment {

	private BankClient bankClient;

	/**
	 * verify appointment
	 * @param bankEmployee
	 */
	public void verifyAppointments(BankEmployee bankEmployee) {
		for (int i = 0; i < bankEmployee.bankClientsWithAppointments.size(); ++i) {

			Date date = bankEmployee.appointmentDates.get(i);
			this.bankClient = bankEmployee.bankClientsWithAppointments.get(i);

			System.out.println("\nCandidate date: " + date + " with Client: " + bankClient.bankClientProfile.name);

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
	
	/**
	 * book it
	 * @param date
	 * @param employeeName
	 */
	public void bookAppointment(Date date, String employeeName) {

		if (date == null || employeeName == null)
			System.err.println("Error book appointment transaction");

		else {

			Appointment appointment = new Appointment(date,employeeName);
			
			if (bankClient.appointments == null)
				bankClient.appointments = new ArrayList<Appointment>();

			bankClient.appointments.add(appointment);
			System.out.println("Appointment has been booked.");
		}
	}

}
