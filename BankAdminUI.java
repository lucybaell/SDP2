package groupProject;

import java.util.ArrayList;

public class BankAdminUI {

	public static void main(String[] args) {

		BankAdmin bankAdmin = new BankAdmin();

		bankAdmin.bankClientsToVerify = new ArrayList<BankClient>();
		bankAdmin.accountNumbersToVerify = new ArrayList<Integer>();

		BankClient bankClient1 = new BankClient("u1", "p1");
		int accountNumber1 = bankClient1.addAccount("primary");
		bankAdmin.bankClientsToVerify.add(bankClient1);
		bankAdmin.accountNumbersToVerify.add(accountNumber1);

		BankClient bankClient2 = new BankClient("u2", "p2");
		int accountNumber2 = bankClient2.addAccount("savings");
		bankAdmin.bankClientsToVerify.add(bankClient2);
		bankAdmin.accountNumbersToVerify.add(accountNumber2);

		BankAdmin.print(bankAdmin.bankClientsToVerify);

		for (int i = 0; i < bankAdmin.accountNumbersToVerify.size(); ++i) {

			int accountNumber = bankAdmin.accountNumbersToVerify.get(i);

			System.out.println("\nAccount number = " + accountNumber);

			System.out.println("1. Verify the opening");
			System.out.println("2. Do not verify the opening");
			String choice = Read.read("choice");

			if (choice.equals("1"))

				CreateBankAccountTransaction createBankAccountTransaction = new CreateBankAccountTransaction();
				createBankAccountTransaction.verify(accountNumber, true);// we assume that we are answering to
			// the client with this call
		}
	}
}
