package gradedGroupProject.nonPrincipledDesign.v1;

public class RegistrationTransactionImpl implements RegistrationTransaction {

	public BankClient register() {
		
		
		BankClient bankClient = new BankClient();
		
		CreateBankClientCredentials createBankClientCridentials = new CreateBankClientCredentials();
		createBankClientCridentials.createBankClientCredentials(bankClient);
		
		CreateProfileTransaction createProfileTransaction = new CreateProfileTransaction();
		createProfileTransaction.createProfile(bankClient);

		
		return bankClient;
	}

}
