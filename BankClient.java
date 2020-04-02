package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BankClient extends Person {

	public static final AtomicInteger clientCount = new AtomicInteger(0);
	public static final AtomicInteger accountCount = new AtomicInteger(0);

	public int clientID;
	public String name;
	public String address;
	public Date birthDate;

	public String username;
	public String password;

	public List<Integer> accountNumbers;
	public List<String> accountTypes;
	public List<Boolean> accountVerified;
	public List<Double> accountBalances;

	public List<Date> appointments;
	public List<String> bankEmployeesWithAppointments;

	public BankClient(String username, String password) {

		this.username = username;
		this.password = password;

		if (username == null || username == null)
			System.err.println("Error register transaction");

		this.clientID = clientCount.incrementAndGet();
	}


	public int addAccount(String accountType) {

		if (accountType == null
				|| (accountType != null && !accountType.equals("primary") && !accountType.equals("savings"))) {

			System.err.println("Error create account transaction");

			return -1;
		}

		else {

			if (accountNumbers == null)
				accountNumbers = new ArrayList<Integer>();
			if (accountTypes == null)
				accountTypes = new ArrayList<String>();
			if (accountVerified == null)
				accountVerified = new ArrayList<Boolean>();
			if (accountBalances == null)
				accountBalances = new ArrayList<Double>();

			accountNumbers.add(accountCount.incrementAndGet());
			accountTypes.add(accountType);
			accountVerified.add(false);
			accountBalances.add(100.0);

			return accountCount.get();
		}
	}

	

	public void verify(int accountNumber, boolean verified) {

		for (int i = 0; i < accountNumbers.size(); ++i)
			if (accountNumbers.get(i) == accountNumber)
				accountVerified.set(i, verified);
	}


	public void toPrint() {

		System.out.println("clientID = " + clientID);

		if (username != null)
			System.out.println("username = " + username);
		if (password != null)
			System.out.println("password = " + password);
		if (name != null)
			System.out.println("name = " + name);
		if (address != null)
			System.out.println("address = " + address);
		if (birthDate != null)
			System.out.println("birthDate = " + birthDate);
		// ***************************
		for (int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i)
			System.out.println("accountType: " + accountTypes.get(i) + "\naccountNumber = " + accountNumbers.get(i)
					+ ", accountVerified = " + accountVerified.get(i) + ", accountBalance = " + accountBalances.get(i)
					+ "\n");
		for (int i = 0; appointments != null && i < appointments.size(); ++i)
			System.out.println("Appointment date: " + appointments.get(i) + "\nBank Employee: "
					+ bankEmployeesWithAppointments.get(i) + ", Scheduled = " + true);
	}

	public void toPrintAccount(int accountNumber) {

		for (int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i) {

			if (accountNumbers.get(i) == accountNumber) {

				System.out.println("accountType: " + accountTypes.get(i));
				System.out.print("accountNumber = " + accountNumbers.get(i));
				System.out.print(", accountVerified = " + accountVerified.get(i));
				System.out.println(", accountBalance = " + accountBalances.get(i) + "\n");
			}
		}
	}

	public void printAccounts() {

		for (int i = 0; accountNumbers != null && i < accountNumbers.size(); ++i) {

			System.out.println("\naccountType: " + accountTypes.get(i));
			System.out.print("accountNumber = " + accountNumbers.get(i));
			System.out.print(", accountVerified = " + accountVerified.get(i));
			System.out.print(", accountBalance = " + accountBalances.get(i));
		}
	}
	

}
