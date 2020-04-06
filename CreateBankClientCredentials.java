package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * creates BankClientCredentials for bank client
 *
 */
public class CreateBankClientCredentials {

	/**
	 * creates credentials and sets them for client in parameter
	 * @param bankClient
	 */
	public void createBankClientCredentials(BankClient bankClient) {
		
		
		String username = Read.read("username");
		while(username.isEmpty()) {//3. Cyber Security - null username given
			System.err.print("Username cannot be null");
			username = Read.read("username");
		}
				
		String password = Read.read("password");
		while(password.isEmpty()) {//3. Cyber Security - null password given
			System.err.print("Password cannot be null");
			password = Read.read("password");
		}

		//creates credentials object
		BankClientCridentials bankClientCridentials = new BankClientCridentials(username, password);
		
		//sets credentials for client in parameter
		bankClient.bankClientCridentials= bankClientCridentials;
	}
}
