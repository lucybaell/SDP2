package groupProject;

import java.util.List;

public class BankAdmin extends Person {

	public String name = "Y";

	public List<BankClient> bankClientsToVerify;
	public List<Integer> accountNumbersToVerify;

	public static void print(List<BankClient> bankClients) {
		for (int i = 0; bankClients != null && i < bankClients.size(); ++i)
			bankClients.get(i).toPrint();
	}
}
