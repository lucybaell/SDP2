package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2. System Design
 * follows the template pattern, allows client to change their details
 *
 */
public class BankClientChangeDetailsTransaction extends TransactionTemplate {

	//bank client profile
	private String name;
	private String address;
	private Date birthDate;
	//bank client creds
	private String username;
	private String password;
	//new profile and credentials
	private BankClientProfile bankClientProfile;
	private BankClientCridentials bankClientCridentials;

	public BankClientChangeDetailsTransaction(BankClient bankClient) {
		
		transaction();//2. System Design (template pattern)
		bankClient.bankClientProfile = bankClientProfile; //sets new profile
		bankClient.bankClientCridentials = bankClientCridentials;//sets new credentials
		
	}

	@Override
	void provideDetails() {
		username = Read.read("new username");
		password = Read.read("new password");

		name = Read.read("new name");
		address = Read.read("new address");

		birthDate = null;

		try {
			birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("new birthDate"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	boolean checkTransaction() {
		if(name == null || address == null || birthDate == null || username == null || password == null)
			return false;
		return true;

	}

	@Override
	void printErrorMessage() {
		if (!checkTransaction())
			System.err.println("Null data was given for change bank client details transaction ");

	}

	@Override
	void executeTransaction() {
		BankClientProfile newProfile = new BankClientProfileConcrete(name, address, birthDate);
		BankClientCridentials newCridentials = new BankClientCridentials(username, password);
		this.bankClientProfile = newProfile;
		this.bankClientCridentials = newCridentials;

	}

}
