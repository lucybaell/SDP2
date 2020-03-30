package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * this class allows the transfer of money between two accounts on the system
 * @author danielmason
 *
 */
public class BankClientMoneyTransferTransaction {

	
	private int toAccountNumber;
	private int fromAccountNumber;
	private int amount;
	private BankClient bankClient;

	public BankClientMoneyTransferTransaction(BankClient bankClient) {
		
		this.bankClient = bankClient;
		bankClient.printAccounts();

		fromAccountNumber = Integer.parseInt(Read.read("from account number"));
		toAccountNumber = Integer.parseInt(Read.read("to account number"));
		amount = Integer.parseInt(Read.read("amount"));

		transfer(fromAccountNumber, toAccountNumber, amount);
	}
	
	public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {

		int from = 0;//money coming from this account

		for (from = 0; from < bankClient.accountNumbers.size(); ++from) {

			if (bankClient.accountNumbers.get(from) == fromAccountNumber) {

				System.out.println("From accountNumber: " + bankClient.accountNumbers.get(from));
				System.out.println("From accountType: " + bankClient.accountTypes.get(from));
				System.out.println("From accountVerified: " + bankClient.accountVerified.get(from));
				System.out.println("From accountBalance: " + bankClient.accountBalances.get(from));
				break;
			}
		}

		int to = 0;//money going to this account

		for (to = 0; to < bankClient.accountNumbers.size(); ++to) {

			if (bankClient.accountNumbers.get(to) == toAccountNumber) {

				System.out.println("To accountType: " + bankClient.accountTypes.get(to));
				System.out.println("To accountNumber: " + bankClient.accountNumbers.get(to));
				System.out.println("To accountVerified: " + bankClient.accountVerified.get(to));
				System.out.println("To accountBalance: " + bankClient.accountBalances.get(to));
				break;
			}
		}

		//if the to and from are valid accounts and the source has the budget
		if (from >= 0 && from < bankClient.accountNumbers.size() && to >= 0 && to < bankClient.accountNumbers.size()
				&& bankClient.accountBalances.get(from) >= amount) {

			bankClient.accountBalances.set(from, bankClient.accountBalances.get(from) - amount);

			bankClient.accountBalances.set(to, bankClient.accountBalances.get(to) + amount);

			System.out.println("\nTransfer is completed\n");
		}

		else
			System.out.println("\nNot enough money in the source\n");
	}

}
