package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;

public class BankEmployeeUI {

	public static void main(String[] args) throws ParseException {

		// hard-coded notifications for appointments with bank client to be scheduled
		BankClient bankClient1 = new BankClient("u1", "p1");
		bankClient1.name = "Alpha";
		BankClient bankClient2 = new BankClient("u2", "p2");
		bankClient2.name = "Bravo";
		BankClient bankClient3 = new BankClient("u3", "p4");
		bankClient3.name = "Charlie";
		BankClient bankClient4 = new BankClient("u4", "p4");
		bankClient4.name = "Delta";

		
		BankEmployee bankEmployee = new BankEmployee("Peggy");
		
		CandidateAppointment canAp = new CandidateAppointment(bankEmployee);
		canAp.appointment(bankClient1, "20/12/2000");
		canAp.appointment(bankClient2, "22/12/2000");
		canAp.appointment(bankClient3, "24/12/2000");
		canAp.appointment(bankClient4, "27/12/2000");
		
		new BankEmployeeVerifyAppointmentsTransaction(bankEmployee);

	}
}
