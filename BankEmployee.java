package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankEmployee extends Person {

	public String name;
	public List<BankClient> bankClientsWithAppointments;
	public List<Date> appointmentDates;
	
	public BankEmployee() {
		
		this.bankClientsWithAppointments = new ArrayList<BankClient>();
		this.appointmentDates = new ArrayList<Date>();
	}
	
	public BankEmployee(String name) {
		super();
		this.name=name;
		this.bankClientsWithAppointments = new ArrayList<BankClient>();
		this.appointmentDates = new ArrayList<Date>();
	}
			
		
}
