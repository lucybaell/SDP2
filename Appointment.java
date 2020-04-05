package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment {

	public Date date;
	public String bankEmployeesWithAppointment;

	public Appointment(Date date, String bankEmployeesWithAppointment) {

		while (!dateNotAfterTodayCheck(date)) {
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
	 * returns false if date is after today
	 * 
	 * @param dateOfAppointment
	 * @return
	 */
	public boolean dateNotAfterTodayCheck(Date dateOfAppointment) {

		Date today = Calendar.getInstance().getTime();

		if (dateOfAppointment.compareTo(today) > 0) {
			System.out.println("Date cannot be after today");
			return false;
		}
		return true;
	}
}
