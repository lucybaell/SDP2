package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.Date;
import java.util.List;

public class BankEmployeeVerifyAppointmentsTransaction {

	public BankEmployee bankEmployee;
	List<BankClient> bankClientsWithAppointments;
	List<Date> appointmentDates;
	

	public BankEmployeeVerifyAppointmentsTransaction(BankEmployee bankEmployee) {
		this.bankEmployee = bankEmployee;
		handleAppointments();
		
	}

	public void handleAppointments() {
		
		ListPrint.print(bankEmployee, bankEmployee.bankClientsWithAppointments);
		BankEmployeeVerifyAppointment verifyAppointments = new BankEmployeeVerifyAppointment();
		verifyAppointments.verifyAppointments(bankEmployee);
		
	}

	
}
