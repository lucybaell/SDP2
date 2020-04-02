package gradedGroupProject.nonPrincipledDesign.v1;

public class BankClientVerificationTransaction {

	public BankClientVerificationTransaction(BankAdmin bankAdmin) {

		for (int i = 0; i < bankAdmin.accountNumbersToVerify.size(); ++i) {

			BankClient bankClient = bankAdmin.bankClientsToVerify.get(i);// bankClient that admin is dealing with
			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);

			System.out.println("\nAccount number = " + accountNumber);

			System.out.println("1. Verify the opening");
			System.out.println("2. Do not verify the opening");
			String choice = Read.read("choice");
			
			while (!choice.equals("1") && !choice.equals("2")) {//while loop ensure valid input
				System.out.print("Select 1 or 2");
				choice = Read.read("choice");
			}
			if (choice.equals("1")) {// The following is a bankclient,verify
				verify(bankClient,accountNumber, true);
				System.out.println("Account number = " + accountNumber+", verified: " + true);

			}
			if (choice.equals("2")) {
				verify(bankClient,accountNumber, false);
				System.out.println("Account number = " + accountNumber+", verified: " + false);

			}

		}
	}
	
	public void verify(BankClient bankClient, int accountNumber, boolean verified) {

		for (int i = 0; i < bankClient.accountNumbers.size(); ++i)
			if (bankClient.accountNumbers.get(i) == accountNumber)
				bankClient.accountVerified.set(i, verified);
	}

}
