package gradedGroupProject.nonPrincipledDesign.v1;

public class BankClientDeleteBankAccountTransaction {

	public BankClient bankClient;
	
	public BankClientDeleteBankAccountTransaction(BankClient bankClient) {

		this.bankClient=bankClient;
		
		bankClient.printAccounts();

		int accountNumber = Integer.parseInt(Read.read("account number for deletion"));

		deleteAccount(accountNumber);

	}

	public void deleteAccount(int accountNumber) {

		int pos = 0;

		for (pos = 0; pos < bankClient.accountNumbers.size(); ++pos)
			if (bankClient.accountNumbers.get(pos) == accountNumber)
				break;

		if (pos >= 0 && pos < bankClient.accountNumbers.size()) {

			bankClient.accountNumbers.remove(pos);
			bankClient.accountTypes.remove(pos);
			bankClient.accountVerified.remove(pos);
			bankClient.accountBalances.remove(pos);

		}
	}
}