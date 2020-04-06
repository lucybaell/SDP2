package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class allows the creation of candidate appointments for BankEmployee to verify
 */

public class CandidateAppointment {

	public BankEmployee bankEmployee;
	
	public CandidateAppointment(BankEmployee bankEmployee) {
		this.bankEmployee=bankEmployee;
	}
	
	/**
	 * schedules appointment
	 * 
	 */
	public void appointment(BankClient bankClient, String date) throws ParseException {
		
		bankEmployee.bankClientsWithAppointments.add(bankClient);
		bankEmployee.appointmentDates.add(new SimpleDateFormat("dd/MM/yyyy").parse(date));
		
	}

	
}
