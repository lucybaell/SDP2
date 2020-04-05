package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;

/**
 * 
 * 
 * this was in his feedback as a recommended class This class is for Candididate
 * bank accounts, it takes a bank client as a parameter the user is asked for
 * the account type it is then added to the bank clients accounts verification
 * is requested from the admin account is verified
 *
 */
public class CandidateBankAccount {

	public String accountType;
	public int accountNumber;
	public boolean verified;

	public String adminName = "Karen";
	private BankClient bankClient;

	/**
	 * this constructor creates a candidate bank account and then asks for/verifies
	 * 
	 * @param bankClient - this is the new bank client registering
	 */
	public CandidateBankAccount(BankClient bankClient) {

		this.bankClient = bankClient;
		this.accountType = Read.read("account type (primary, savings)");
		this.accountNumber = addAccount(accountType);
		boolean verified = askForVerification(bankClient.clientID, accountNumber, adminName); // contact bank admin

		verify(accountNumber, verified);

	}
	
	public CandidateBankAccount(BankClient bankClient, String accountype) {

		this.bankClient = bankClient;
		this.accountNumber = addAccount(accountType);
		boolean verified = askForVerification(bankClient.clientID, accountNumber, adminName); // contact bank admin

		verify(accountNumber, verified);

	}

	public boolean askForVerification(int clientID, int accountNumber, String adminName) {

		// Assume we sent a message to bank admin

		return true;
	}

	public void verify(int accountNumber, boolean verified) {

		for (int i = 0; i < bankClient.bankAccounts.size(); ++i)
			if (bankClient.bankAccounts.get(i).accountNumber == accountNumber)
				bankClient.bankAccounts.get(i).accountVerified = verified;
	}
	
	/**
	 * for creating/adding a bank account to the BankClients accounts
	 * 
	 * @param accountType
	 * @return
	 */
	public int addAccount(String accountType) {

		if (bankClient.bankAccounts == null) {
			bankClient.bankAccounts = new ArrayList<BankAccount>();
		}
		if (accountType.equals("primary")) {
			BankAccount newBankAccount = new BankAccountPrimary();
			bankClient.bankAccounts.add(newBankAccount);

			return newBankAccount.accountNumber;
		}

		if (accountType.equals("savings")) {
			BankAccount newBankAccount = new BankAccountSavings();
			bankClient.bankAccounts.add(newBankAccount);
			return newBankAccount.accountNumber;
		}

		if (accountType == null
				|| (accountType != null && !accountType.equals("primary") && !accountType.equals("savings"))) {

			System.err.println("Error create bank account transaction");

			return -1;
		}

		else {

			return -1;
		}
		
	}

}