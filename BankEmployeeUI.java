package gradedGroupProject.nonPrincipledDesign.v1;


import java.text.ParseException;

public class BankEmployeeUI {

	public static void main(String[] args) throws ParseException {

		// hard-coded notifications for appointments with bank client to be scheduled
		BankClient bankClient1 = new BankClient("u1", "p1");
		bankClient1.bankClientProfile = new BankClientProfileConcrete("A", null, null) ;
		BankClient bankClient2 = new BankClient("u2", "p2");
		bankClient2.bankClientProfile = new BankClientProfileConcrete("B", null, null) ;
		BankClient bankClient3 = new BankClient("u3", "p4");
		bankClient3.bankClientProfile = new BankClientProfileConcrete("C", null, null) ;
		BankClient bankClient4 = new BankClient("u4", "p4");
		bankClient4.bankClientProfile = new BankClientProfileConcrete("D", null, null) ;

		
		BankEmployee bankEmployee = new BankEmployee("Peggy");
		
		CandidateAppointment canAp = new CandidateAppointment(bankEmployee);
		canAp.appointment(bankClient1, "20/12/2000");
		canAp.appointment(bankClient2, "22/12/2000");
		canAp.appointment(bankClient3, "24/12/2000");
		canAp.appointment(bankClient4, "27/12/2000");
		
		new BankEmployeeVerifyAppointmentsTransaction(bankEmployee);

	}
}
