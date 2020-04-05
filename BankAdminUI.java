package gradedGroupProject.nonPrincipledDesign.v1;


public class BankAdminUI {

	public static void main(String[] args) {

		BankAdmin bankAdmin = new BankAdmin();

		//HARD CODED BANK CLIENTS ACCOUNTS WAITING FOR VERIFICATION
		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		bankAdmin.bankClientsToVerify.add(bankClient1);
		bankAdmin.accountNumbersToVerify.add(accountNumber1);

		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		bankAdmin.bankClientsToVerify.add(bankClient2);
		bankAdmin.accountNumbersToVerify.add(accountNumber2);

		ListPrint.print(bankAdmin.bankClientsToVerify);

		new BankAdminVerificationTransaction(bankAdmin);

	}

}
