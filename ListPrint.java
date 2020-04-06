package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.List;

/**
 * allows formatted printing of various groups
 *
 */
public class ListPrint {

	/**
	 * for bank client print
	 */
	public static void print(List<BankClient> bankClient) {

		for (int i = 0; bankClient != null && i < bankClient.size(); ++i)
			bankClient.get(i).toPrint();
	}

	/**
	 * prints appointments
	 * @param bankEmployee
	 * @param bankClient
	 */
	public static void print(BankEmployee bankEmployee, List<BankClient> bankClient) {

		for (int i = 0; bankEmployee.bankClientsWithAppointments != null
				&& i < bankEmployee.bankClientsWithAppointments.size(); ++i) {
			System.out.println("\nAppointment Date: " + bankEmployee.appointmentDates.get(i));
			bankEmployee.bankClientsWithAppointments.get(i).toPrint();
		}
	}

}