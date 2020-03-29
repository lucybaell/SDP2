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

			ListPrint.print(bankClients);

			System.out.println("\n0. Exit");
			System.out.println("1. Register"); // --> Create Profile --> Create Account --> Create Further Accounts
			System.out.println("4. Login");
			String choice = Read.read("choice");

			if (choice.equals("0")) // exit
				break;

			else if (choice.equals("1")) {// register

				RegistrationTransaction registrationTransaction = new RegistrationTransactionImpl();
				/*
				 * possible line 37 to line 54
				 * can be put into registrationTransaction class bankClients.add(bankClient);
				 * will be only thing that will be tricky, register would have to return a
				 * BankClient or take the bankClients list as parameter and change it within
				 */
				BankClient bankClient = registrationTransaction.register();
				bankClients.add(bankClient);

				CreateProfileTransaction createProfileTransaction = new CreateProfileTransaction();
				createProfileTransaction.createProfile(bankClient);

				while (true) {// while client not adding banks accounts
					// ********************
					new CandidateBankAccount(bankClient);

					System.out.println("\n0. NO extra account");
					System.out.println("1. Extra account");
					String choice2 = Read.read("choice");

					if (choice2.equals("0"))
						break;

				}
			}

			else if (choice.equals("4")) {// login (scans through registered usernames passwords)

				BankClientLogin bankClientLogin = new BankClientLogin(bankClients);
				bankClientLogin.login();
				if (!bankClientLogin.successfulLogin()) {
					// prints error and repeats whole while loop
				}

				else {

					int pos = bankClientLogin.getPos();// this is t get the bank clients pos in the array
					int accountNumber = Integer.parseInt(Read.read("account number"));
					bankClients.get(pos).toPrintAccount(accountNumber);

					System.out.println("\n0. Exit");
					System.out.println("5. Change Bank Client Details");
					System.out.println("6. Delete Bank Account");
					System.out.println("7. Money transfer");
					System.out.println("8. Book Appoinment");
					choice = Read.read("choice");

					if (choice.equals("5")) {// 5. Change Bank Client Details

						new BankClientChangeDetailsTransaction(bankClients.get(pos));

					}

					else if (choice.equals("6")) {// Delete Bank Account

						new BankClientDeleteBankAccountTransaction(bankClients.get(pos));

						if (bankClients.get(pos).accountNumbers.size() == 0) //if bank client has no accounts they are removed
							bankClients.remove(pos);

					}

					else if (choice.equals("7")) {// Money transfer

						bankClients.get(pos).printAccounts();

						int fromAccountNumber = Integer.parseInt(Read.read("from account number"));
						int toAccountNumber = Integer.parseInt(Read.read("to account number"));
						double amount = Integer.parseInt(Read.read("amount"));

						bankClients.get(pos).transfer(fromAccountNumber, toAccountNumber, amount);
					}

					else if (choice.equals("8")) {// Book Appoinment

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
