package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.List;

/**
 * this class should take the bankClients list and ask for username and password
 * if the un and pw match any bankClients, login should be true
 * 
 * @author danielmason
 *
 */
public class BankClientLogin {

	public boolean successfulLogin = false;
	public int pos = 0;
	List<BankClient> bankClients;

	public BankClientLogin(List<BankClient> bankClients) {
		this.bankClients = bankClients;
	}

	public boolean login() {

		String username = Read.read("username");
		String password = Read.read("password");

		int pos = 0;

		for (pos = 0; pos < bankClients.size(); ++pos)

			if (bankClients.get(pos).bankClientCridentials.username.equals(username)
					&& bankClients.get(pos).bankClientCridentials.password.equals(password))
				break;

		if (pos < 0 || pos >= bankClients.size()) {

			System.out.println("Bank client credentials were not found.");
			return false;

		} else {

			this.successfulLogin = true;
			bankClients.get(pos).toPrint();

			return true;

		}

	}

	public int getPos() {
		return this.pos;
	}

	public boolean successfulLogin() {
		return this.successfulLogin;
	}

}
