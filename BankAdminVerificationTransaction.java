package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * iterates through accounts for verification and asks bank admin to verify or
 * not to verify
 *
 */
public class BankAdminVerificationTransaction {

	/**
	 * BankAdmin requirements are performed when this transaction instantiated
	 * @param bankAdmin
	 */
	public BankAdminVerificationTransaction(BankAdmin bankAdmin) {

		for (int i = 0; i < bankAdmin.accountNumbersToVerify.size(); ++i) {

			BankClient bankClient = bankAdmin.bankClientsToVerify.get(i);// bankClient that admin is dealing with
			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);// bank client account that admin is dealing with

			System.out.println("\nAccount number = " + accountNumber);

			System.out.println("1. Verify the opening");
			System.out.println("2. Do not verify the opening");
			String choice = Read.read("choice");

			while (!choice.equals("1") && !choice.equals("2")) {// while loop ensure valid input
				System.out.print("Select 1 or 2");
				choice = Read.read("choice");
			}

			if (choice.equals("1")) {// The following is a BankAccount verify
				verify(bankClient, accountNumber, true);
				System.out.println("Account number = " + accountNumber + ", verified: " + true);

			}
			if (choice.equals("2")) {//the following is a BankAccount not being verified
				verify(bankClient, accountNumber, false);
				System.out.println("Account number = " + accountNumber + ", verified: " + false);

			}

		}
	}

	/**
	 * changes a BankAccount verified to true is Admin calls for it
	 * 
	 * @param bankClient
	 * @param accountNumber
	 * @param verified
	 */
	public void verify(BankClient bankClient, int accountNumber, boolean verified) {

		for (int i = 0; i < bankClient.bankAccounts.size(); ++i)
			if (bankClient.bankAccounts.get(i).accountNumber == accountNumber)
				bankClient.bankAccounts.get(i).accountVerified = verified;
	}

}
