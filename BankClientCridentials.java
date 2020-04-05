package gradedGroupProject.nonPrincipledDesign.v1;

public class BankClientCridentials {

	public String username;
	public String password;

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
	 * returns true if the username does not start with '$'
	 * @param username
	 * @return
	 */
	public boolean checkFakeUsername(String username) {

		if (username.charAt(0)== '$') {
			System.out.print("Fake Username was provided");
			return false;
		}
		
		return true;
	}

	/**
	 * returns true if password does not end with '.'
	 * @param password
	 * @return
	 */
	public boolean checkFakePassword(String password) {

		if (password.charAt(password.length()-1)=='.') {
			System.out.print("Fake Password was provided");
			return false;
		}
		
		return true;
	}
}
