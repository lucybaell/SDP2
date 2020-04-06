package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * bank client accounts listed and client asked for account number they want to
 * delete
 *
 */
public class BankClientDeleteBankAccountTransaction {

	private BankClient bankClient;

	/**
	 * prints accounts and asked which one to delete
	 * 
	 * @param bankClient
	 */
	public BankClientDeleteBankAccountTransaction(BankClient bankClient) {

		this.bankClient = bankClient;

		bankClient.printAccounts();

		int accountNumber = Integer.parseInt(Read.read("account number for deletion"));

		deleteAccount(accountNumber);

	}

	/**
	 * takes an account number and if a bank clients account numbers match it, that
	 * account will be deleted
	 * 
	 * @param accountNumber
	 */
	private void deleteAccount(int accountNumber) {

		int pos = 0;

		for (pos = 0; pos < bankClient.bankAccounts.size(); ++pos)
			if (bankClient.bankAccounts.get(pos).accountNumber == accountNumber)
				break;

		if (pos >= 0 && pos < bankClient.bankAccounts.size()) {

			bankClient.bankAccounts.remove(pos);

		}
	}
}