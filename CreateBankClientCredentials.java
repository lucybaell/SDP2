package gradedGroupProject.nonPrincipledDesign.v1;


public class CreateBankClientCredentials {

	public void createBankClientCredentials(BankClient bankClient) {
		
		String username = Read.read("username");
		String password = Read.read("password");

		BankClientCridentials bankClientCridentials = new BankClientCridentials(username, password);
		
		bankClient.bankClientCridentials= bankClientCridentials;
	}
}
