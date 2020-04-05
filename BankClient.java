package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BankClient extends Person {

	public static final AtomicInteger clientCount = new AtomicInteger(0);
	public static final AtomicInteger accountCount = new AtomicInteger(0);

	public int clientID;
	public BankClientProfile bankClientProfile;
	public BankClientCridentials bankClientCridentials;
	public List<BankAccount> bankAccounts;
	public List<Appointment> appointments;

	public BankClient() {
		this.clientID = clientCount.incrementAndGet();
	}

	public BankClient(String username, String password) {

		this.bankClientCridentials = new BankClientCridentials(username, password);

		if (username == null || username == null)
			System.err.println("Error register transaction");

		this.clientID = clientCount.incrementAndGet();
	}

	public int addAccount(String accountType) {

		if (bankAccounts == null) {
			bankAccounts = new ArrayList<BankAccount>();
		}
		if (accountType.equals("primary")) {
			BankAccount newBankAccount = new BankAccountPrimary();
			bankAccounts.add(newBankAccount);
		}

		if (accountType.equals("savings")) {
			BankAccount newBankAccount = new BankAccountSavings();
			bankAccounts.add(newBankAccount);
		}

		if (accountType == null
				|| (accountType != null && !accountType.equals("primary") && !accountType.equals("savings"))) {

			System.err.println("Error create account transaction");

			return -1;
		}

		else {

			return accountCount.incrementAndGet();
		}
	}

	public void verify(int accountNumber, boolean verified) {

		for (int i = 0; i < bankAccounts.size(); ++i)
			if (bankAccounts.get(i).accountNumber == accountNumber)
				bankAccounts.get(i).accountVerified = verified;
	}

	public void toPrint() {

		System.out.println("clientID = " + clientID);

		if (bankClientCridentials.username != null)
			System.out.println("username = " + bankClientCridentials.username);
		if (bankClientCridentials.password != null)
			System.out.println("password = " + bankClientCridentials.password);
		if (bankClientProfile.name != null)
			System.out.println("name = " + bankClientProfile.name);
		if (bankClientProfile.address != null)
			System.out.println("address = " + bankClientProfile.address);
		if (bankClientProfile.birthDate != null)
			System.out.println("birthDate = " + bankClientProfile.birthDate);

		for (int i = 0; bankAccounts != null && i < bankAccounts.size(); ++i)
			System.out.println("accountType: " + bankAccounts.get(i).accountType + "\naccountNumber = "
					+ bankAccounts.get(i).accountNumber + ", accountVerified = " + bankAccounts.get(i).accountVerified
					+ ", accountBalance = " + bankAccounts.get(i).accountBalance + "\n");
		for (int i = 0; appointments != null && i < appointments.size(); ++i)
			System.out.println("Appointment date: " + appointments.get(i).date + "\nBank Employee: "
					+ appointments.get(i).bankEmployeesWithAppointment + ", Scheduled = " + true);
	}

	public void toPrintAccount(int accountNumber) {

		for (int i = 0; bankAccounts != null && i < bankAccounts.size(); ++i) {

			if (bankAccounts.get(i).accountNumber == accountNumber) {

				System.out.println("accountType: " + bankAccounts.get(i).accountType);
				System.out.print("accountNumber = " + bankAccounts.get(i).accountNumber);
				System.out.print(", accountVerified = " + bankAccounts.get(i).accountVerified);
				System.out.println(", accountBalance = " + bankAccounts.get(i).accountBalance + "\n");
			}
		}
	}

	public void printAccounts() {

		for (int i = 0; bankAccounts != null && i < bankAccounts.size(); ++i) {

			System.out.println("\naccountType: " + bankAccounts.get(i).accountType);
			System.out.print("accountNumber = " + bankAccounts.get(i).accountNumber);
			System.out.print(", accountVerified = " + bankAccounts.get(i).accountVerified);
			System.out.print(", accountBalance = " + bankAccounts.get(i).accountBalance);
		}
	}

}
