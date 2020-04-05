package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankClientUI {

	public static void main(String[] args) throws ParseException {

		List<BankClient> bankClients = new ArrayList<>();

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
				BankClient bankClient = registrationTransaction.register();
				bankClients.add(bankClient);

				while (true) {// while client not adding banks accounts

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
					
					BankClient bankClient = bankClients.get(pos);
					// appendix 23 24 not sure why he wants this but i put it in
					int accountNumber = Integer.parseInt(Read.read("account number"));
					bankClient.toPrintAccount(accountNumber);
					while (true) {
						ListPrint.print(bankClients);
						System.out.println("\n0. Log Out \n5. Change Bank Client Details \n6. Delete Bank Account "
								+ "\n7. Money transfer \n8. Book Appoinment");
						choice = Read.read("choice");

						if (choice.equals("0")) {// Log Out
							break;
						}
						
						if (choice.equals("5")) {// 5. Change Bank Client Details
							new BankClientChangeDetailsTransaction(bankClient);
						}

						else if (choice.equals("6")) {// Delete Bank Account
							new BankClientDeleteBankAccountTransaction(bankClient);
							if (bankClient.bankAccounts.size() == 0) // if bank client has no accounts they are
																		// removed
								bankClients.remove(pos);
						}

						else if (choice.equals("7")) {// Money transfer
							new BankClientMoneyTransferTransaction(bankClients.get(pos));
						}

						else if (choice.equals("8")) {// Book Appointment
							new BankClientBookAppointmentTransaction(bankClient);
						}
					}
				}
			}
		}
	}
}
