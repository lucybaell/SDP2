package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * 
 * @author danielmason
 * this was in his feedback as a recommended class
 * This class is for Candididate bank accounts, it takes a bank client as a parameter
 * the user is asked for the account type
 * it is then added to the bank clients accounts
 * verification is requested from the admin
 * account is verified
 *
 */
public class CandidateBankAccount {

	public String accountType;
	public int accountNumber;
	public boolean verified;
	
	public String adminName = "X";

	/**
	 * this constructor creates a candidate bank account and then asks for/verifies
	 * @param bankClient - this is the new bank client registering
	 */
	public CandidateBankAccount(BankClient bankClient) {

			accountType = Read.read("account type (primary, savings)");
			accountNumber = bankClient.addAccount(accountType);
			boolean verified = askForVerification(bankClient.clientID, accountNumber, adminName); // TODO:
																												// contact
																												// bank
																												// admin

			bankClient.verify(accountNumber, verified);

			
		
	}
	
	public boolean askForVerification(int clientID, int accountNumber, String adminName) {

		// Assume we sent a message to bank admin

		return true;
	}

}