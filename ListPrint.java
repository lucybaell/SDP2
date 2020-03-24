package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.List;

public class ListPrint {

	public static void print(List<BankClient> bankClient) {

		for (int i = 0; bankClient != null && i < bankClient.size(); ++i)
			bankClient.get(i).toPrint();
	}

	// MAY NEED MODICIFICATION DEPENDING ON CLIENT
	public static void print(BankEmployee bankEmployee, List<BankClient> bankClient) {

		for (int i = 0; bankEmployee.bankClientsWithAppointments != null
				&& i < bankEmployee.bankClientsWithAppointments.size(); ++i) {
			System.out.println("\nAppointment Date: " + bankEmployee.appointmentDates.get(i));
			bankEmployee.bankClientsWithAppointments.get(i).toPrint();
			System.out.println("Username: " + bankEmployee.bankClientsWithAppointments.get(i).username);
			System.out.println("Password: " + bankEmployee.bankClientsWithAppointments.get(i).password);
		}
	}

}