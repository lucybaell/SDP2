package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankClientUI {

	public static void main(String[] args) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();

		String employeeName = "Y";

		while (true) {

			print(bankClients);

			System.out.println("\n0. Exit");
			System.out.println("1. Register"); // --> Create Profile --> Create Account --> Create Further Accounts
			System.out.println("4. Login");
			String choice = Read.read("choice");

			if (choice.equals("0")) //exit
				break;

			else if (choice.equals("1")) {//register

				RegistrationTransaction registrationTransaction = new RegistrationTransactionImpl();
				// ***********************************************
				// possible line 37 to line 54 can be put into registrationTransaction class
				// bankClients.add(bankClient); will be only thing that will be tricky, register
				// would have to return a BankClient or take the bankClients list as parameter
				// and change it within
				BankClient bankClient = registrationTransaction.register();
				bankClients.add(bankClient);

				CreateProfileTransaction createProfileTransaction = new CreateProfileTransaction();
				createProfileTransaction.createProfile(bankClient);

				while (true) {//while client not adding banks accounts
					// ********************
					new CandidateBankAccount(bankClient);

					System.out.println("\n0. NO extra account");
					System.out.println("1. Extra account");
					String choice2 = Read.read("choice");

					if (choice2.equals("0"))
						break;

				}
			}

			else if (choice.equals("4")) {//login (scans through registered usernames passwords)

				String username = Read.read("username");
				String password = Read.read("password");

				int pos = 0;

				for (pos = 0; pos < bankClients.size(); ++pos)
					if (bankClients.get(pos).username.equals(username)
							&& bankClients.get(pos).password.equals(password))
						break;

				if (pos < 0 || pos >= bankClients.size())
					System.err.println("Bank client credentials were not found.");

				else {

					bankClients.get(pos).toPrint();

					int accountNumber = Integer.parseInt(Read.read("account number"));

					bankClients.get(pos).toPrintAccount(accountNumber);

					System.out.println("\n0. Exit");
					System.out.println("5. Change Bank Client Details");
					System.out.println("6. Delete Bank Account");
					System.out.println("7. Money transfer");
					System.out.println("8. Book Appoinment");
					choice = Read.read("choice");

					if (choice.equals("5")) {

						String name = Read.read("new name");
						String address = Read.read("new address");

						Date birthDate = null;
						try {
							birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("new birthDate"));
						} catch (ParseException ex) {
							ex.printStackTrace();
						}

						username = Read.read("new username");
						password = Read.read("new password");

						bankClients.get(pos).changeClientDetails(name, address, birthDate, username, password);
					}

					else if (choice.equals("6")) {

						bankClients.get(pos).printAccounts();

						accountNumber = Integer.parseInt(Read.read("account number"));

						bankClients.get(pos).deleteAccount(accountNumber);

						if (bankClients.get(pos).accountNumbers.size() == 0)
							bankClients.remove(pos);
					}

					else if (choice.equals("7")) {

						bankClients.get(pos).printAccounts();

						int fromAccountNumber = Integer.parseInt(Read.read("from account number"));
						int toAccountNumber = Integer.parseInt(Read.read("to account number"));
						double amount = Integer.parseInt(Read.read("amount"));

						bankClients.get(pos).transfer(fromAccountNumber, toAccountNumber, amount);
					}

					else if (choice.equals("8")) {

						Date appointmentDate = null;
						try {
							appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("apppoinment date"));
						} catch (ParseException ex) {
							ex.printStackTrace();
						}

						boolean scheduled = bankClients.get(pos).askForSchedulingAppointment(
								bankClients.get(pos).clientID, appointmentDate, employeeName);

						if (scheduled)
							bankClients.get(pos).bookAppointment(appointmentDate, employeeName);

						else
							System.err.println("The appointment has not been booked");
					}
				}
			}
		}
	}

	public static void print(List<BankClient> bankClients) {

		System.out.println("Bank Clients:\n");

		for (int i = 0; bankClients != null && i < bankClients.size(); ++i)
			bankClients.get(i).toPrint();
	}
}
