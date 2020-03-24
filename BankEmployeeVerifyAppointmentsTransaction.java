package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.Date;
import java.util.List;

public class BankEmployeeVerifyAppointmentsTransaction {

	public BankEmployee bankEmployee;
	List<BankClient> bankClientsWithAppointments;
	List<Date> appointmentDates;
	

	public BankEmployeeVerifyAppointmentsTransaction(BankEmployee bankEmployee) {
		this.bankEmployee = bankEmployee;
		this.bankClientsWithAppointments=bankEmployee.bankClientsWithAppointments;
		this.appointmentDates=bankEmployee.appointmentDates;
		handleAppointments();
		
	}

	public void handleAppointments() {
		
		ListPrint.print(bankEmployee, bankClientsWithAppointments);
		BankEmployeeVerifyAppointment verifyAppointments = new BankEmployeeVerifyAppointment();
		verifyAppointments.verifyAppointments(bankEmployee);
		
	}

	
}
