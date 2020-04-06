package gradedGroupProject.nonPrincipledDesign.v1;


/**
 * class allowing scheduling of bank employees appointments
 *
 */
public class BankEmployeeVerifyAppointmentsTransaction {

	public BankEmployee bankEmployee;
	

	public BankEmployeeVerifyAppointmentsTransaction(BankEmployee bankEmployee) {
		this.bankEmployee = bankEmployee;
		handleAppointments();
		
	}

	/**
	 * uses BankEmployeeVerifyAppointment to manage scheduling of appointments
	 * 
	 */
	public void handleAppointments() {
		
		ListPrint.print(bankEmployee, bankEmployee.bankClientsWithAppointments);//prints appointment
		BankEmployeeVerifyAppointment verifyAppointments = new BankEmployeeVerifyAppointment();//asks user to verify or not
		verifyAppointments.verifyAppointments(bankEmployee);//Schedules or doesn't
		
	}

	
}
