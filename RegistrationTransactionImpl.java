package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * allows a Bank Client to register by creating profile and credentials 
 *
 */
public class RegistrationTransactionImpl implements RegistrationTransaction {

	public BankClient register() {
		
		
		BankClient bankClient = new BankClient();//new bank client
		
		//create username and password
		CreateBankClientCredentials createBankClientCridentials = new CreateBankClientCredentials();
		createBankClientCridentials.createBankClientCredentials(bankClient);
		
		//create name, address and dob
		CreateProfileTransaction createProfileTransaction = new CreateProfileTransaction();
		createProfileTransaction.createProfile(bankClient);

		
		return bankClient;
	}

}
