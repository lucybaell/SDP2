package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * Credentials necessary for Log In 
 *
 */
public class BankClientCridentials {

	public String username;
	public String password;

	/**
	 * 3. Cyber-Security
	 * takes a username and password and sets them, while they are fake data user asked for real date
	 * @param username
	 * @param password
	 */
	public BankClientCridentials(String username, String password) {

		while (!checkFakeUsername(username)) {
			username = Read.read("username");
		}
		this.username = username;

		while (!checkFakePassword(password)) {
			password = Read.read("password");
		}
		this.password = password;
	}

	/**
	 * 3.Cyber Security returns false if the username start with '$'
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkFakeUsername(String username) {

		if (!username.isEmpty()) {
			if (username.charAt(0) == '$') {
				System.err.print("Fake Username was provided\n");
				return false;
			}
		}

		return true;
	}

	/**
	 * 3.Cyber Security returns true if password does not end with '.'
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkFakePassword(String password) {

		if (!password.isEmpty()) {
			if (password.charAt(password.length() - 1) == '.') {
				System.err.print("Fake Password was provided\n");
				return false;
			}
		}
		return true;
	}
}
