package gradedGroupProject.nonPrincipledDesign.v1;

public class RegistrationTransactionImpl implements RegistrationTransaction {

	String username;
	String password;

	public BankClient register() {
		username = Read.read("username");
		password = Read.read("password");

		BankClient bankClient = new BankClient(username, password);
		return bankClient;
	}

}
