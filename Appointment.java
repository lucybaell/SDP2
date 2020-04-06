package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * holds an appointment data for a bank client
 *
 */
public class Appointment {

	public Date date; //holds the date of the appointment
	public String bankEmployeesWithAppointment; //holds the name of employee appointment is with

	public Appointment(Date date, String bankEmployeesWithAppointment) {

		while (!dateNotAfterTodayCheck(date)) { //3. cyber security - if date is after today
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("apppoinment date"));
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
		}
		
		this.date = date;
		this.bankEmployeesWithAppointment = bankEmployeesWithAppointment;
	}

	/**
	 * 3. Cyber Security
	 * returns false if date is after today
	 * 
	 * @param dateOfAppointment
	 * @return
	 */
	public boolean dateNotAfterTodayCheck(Date dateOfAppointment) {

		Date today = Calendar.getInstance().getTime();

		if (dateOfAppointment.compareTo(today) > 0) {
			System.err.println("Appointment Date cannot be after today\n");
			return false;
		}
		return true;
	}
}
