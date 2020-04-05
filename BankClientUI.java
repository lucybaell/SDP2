package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;

public class BankClientUI {

	public static void main(String[] args) throws ParseException {

		//List<BankClient> bankClients = new ArrayList<>();
		
		//part 2.2 system design (singleton pattern)
		BankClientDictionarySingleton bankClientDictionarySingleton = BankClientDictionarySingleton.getSingletonInstance();

		while (true) {

			ListPrint.print(bankClientDictionarySingleton.getBankClients());

			System.out.println("\n0. Exit");
			System.out.println("1. Register"); // --> Create Profile --> Create Account --> Create Further Accounts
			System.out.println("4. Login");
			String choice = Read.read("choice");

			if (choice.equals("0")) // exit
				break;

			else if (choice.equals("1")) {// register

				RegistrationTransaction registrationTransaction = new RegistrationTransactionImpl();
				BankClient bankClient = registrationTransaction.register();
				//bankClients.add(bankClient);
				bankClientDictionarySingleton.addBankClient(bankClient);

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

				BankClientLogin bankClientLogin = new BankClientLogin(bankClientDictionarySingleton.getBankClients());
				bankClientLogin.login();
				if (!bankClientLogin.successfulLogin()) {
					// prints error and repeats whole while loop
				}

				else {

					int index = bankClientLogin.getIndex();// this is t get the bank clients pos in the array
					
					BankClient bankClient = bankClientDictionarySingleton.getBankClient(index);// this deals with which bankclient has logged in
					System.out.println("bank client has values: "+ bankClient.clientID);
					// appendix 23 24 not sure why he wants this but i put it in
					int accountNumber = Integer.parseInt(Read.read("account number"));
					bankClient.toPrintAccount(accountNumber);
					while (true) {
						bankClientDictionarySingleton.printBankClient(index);
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
							if (bankClient.bankAccounts.size() == 0) { // if bank client has no accounts they are
																		// removed
								bankClientDictionarySingleton.deleteBankClient(index);
								System.out.println("No Accounts open, Bank Client deleted");
								break;
							}
						}

						else if (choice.equals("7")) {// Money transfer
							new BankClientMoneyTransferTransaction(bankClient);
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
