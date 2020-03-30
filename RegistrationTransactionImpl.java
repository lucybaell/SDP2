package gradedGroupProject.nonPrincipledDesign.v1;

public class RegistrationTransactionImpl implements RegistrationTransaction {

	private String username;
	private String password;

	public BankClient register() {
		this.username = Read.read("username");
		this.password = Read.read("password");

		BankClient bankClient = new BankClient(username, password);
		return bankClient;
	}

}
