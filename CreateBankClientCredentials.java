package gradedGroupProject.nonPrincipledDesign.v1;


public class CreateBankClientCredentials {

	public void createBankClientCredentials(BankClient bankClient) {
		
		String username = Read.read("username");
		while(username.isEmpty()) {
			System.err.print("Username cannot be null");
			username = Read.read("username");
		}
				
		String password = Read.read("password");
		while(password.isEmpty()) {
			System.err.print("Password cannot be null");
			password = Read.read("password");
		}

		BankClientCridentials bankClientCridentials = new BankClientCridentials(username, password);
		
		bankClient.bankClientCridentials= bankClientCridentials;
	}
}
