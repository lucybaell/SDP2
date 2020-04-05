package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BankClientBookAppointmentTransaction {

	private String employeeName = "Captain Cuddles";
	private BankClient bankClient;
	
	public BankClientBookAppointmentTransaction(BankClient bankClient) {
		
		this.bankClient = bankClient;
		Date appointmentDate = null;
		try {
			appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("apppoinment date"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		boolean scheduled = askForSchedulingAppointment(
				bankClient.clientID, appointmentDate, employeeName);

		if (scheduled)
			bookAppointment(appointmentDate, employeeName);

		else
			System.err.println("The appointment has not been booked");
	}


	public boolean askForSchedulingAppointment(int clientID, Date date, String employeeName) {

		if (date == null || employeeName == null) {

			System.err.println("Error schedule appointment transaction");

			return false;
		}

		else {

			// Assume we sent a message to bank employee

			return true;
		}
	}

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
