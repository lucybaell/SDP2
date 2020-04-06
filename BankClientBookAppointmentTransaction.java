package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * allows the bank client to book an appointment
 *
 */
public class BankClientBookAppointmentTransaction {

	private String employeeName = "Captain Cuddles";//employee appointment with
	private BankClient bankClient;
	
	public BankClientBookAppointmentTransaction(BankClient bankClient) {
		
		this.bankClient = bankClient;
		//ask for appointment date
		Date appointmentDate = null;
		try {
			appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("apppoinment date"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		//ask for it to be scehduled
		boolean scheduled = askForSchedulingAppointment(
				bankClient.clientID, appointmentDate, employeeName);

		//after its scheduled, book the appointment with employee
		if (scheduled)
			bookAppointment(appointmentDate, employeeName);

		else
			System.err.println("The appointment has not been booked");
	}


	/**
	 * asks employee to schedule appointment
	 * 
	 * @param clientID
	 * @param date
	 * @param employeeName
	 * @return
	 */
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

	/**
	 * books the appointment and adds it to BankClients appointment list
	 * 
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
