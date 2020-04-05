package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * this class allows the transfer of money between two accounts on the system
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

		for (from = 0; from < bankClient.bankAccounts.size(); ++from) {

			if (bankClient.bankAccounts.get(from).accountNumber == fromAccountNumber) {

				System.out.println("From accountNumber: " + bankClient.bankAccounts.get(from).accountNumber);
				System.out.println("From accountType: " + bankClient.bankAccounts.get(from).accountType);
				System.out.println("From accountVerified: " + bankClient.bankAccounts.get(from).accountVerified);
				System.out.println("From accountBalance: " + bankClient.bankAccounts.get(from).accountBalance);
				break;
			}
		}

		int to = 0;//money going to this account

		for (to = 0; to < bankClient.bankAccounts.size(); ++to) {

			if (bankClient.bankAccounts.get(to).accountNumber == toAccountNumber) {

				System.out.println("To accountType: " + bankClient.bankAccounts.get(to).accountType);
				System.out.println("To accountNumber: " + bankClient.bankAccounts.get(to).accountNumber);
				System.out.println("To accountVerified: " + bankClient.bankAccounts.get(to).accountVerified);
				System.out.println("To accountBalance: " + bankClient.bankAccounts.get(to).accountBalance);
				break;
			}
		}

		//if the to and from are valid accounts and the source has the budget
		if (from >= 0 && from < bankClient.bankAccounts.size() && to >= 0 && to < bankClient.bankAccounts.size()
				&& bankClient.bankAccounts.get(from).accountBalance >= amount) {

			bankClient.bankAccounts.get(from).accountBalance-=amount;
			bankClient.bankAccounts.get(to).accountBalance+=amount;

			System.out.println("\nTransfer is completed\n");
		}

		else
			System.out.println("\nNot enough money in the source\n");
	}

}
