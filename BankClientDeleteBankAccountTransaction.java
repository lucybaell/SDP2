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

		for (pos = 0; pos < bankClient.bankAccounts.size(); ++pos)
			if (bankClient.bankAccounts.get(pos).accountNumber == accountNumber)
				break;

		if (pos >= 0 && pos < bankClient.bankAccounts.size()) {

			bankClient.bankAccounts.remove(pos);
			
		}
	}
}