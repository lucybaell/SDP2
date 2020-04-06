package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2. System Design
 * Applies template pattern, it creates a profile for the bank client during registration
 *
 */
public class CreateProfileTransaction extends TransactionTemplate {

	//data required for profile
	private String name;
	private String address;
	private Date birthDate;
	//new profile for bank client
	private BankClientProfile bankClientProfile;

	/**
	 * carries out profile creation for bank client in parameter
	 * @param bankClient
	 */
	public void createProfile(BankClient bankClient) {
	
		transaction();//2. template pattern
		bankClient.bankClientProfile = this.bankClientProfile;
		
	}

	@Override
	void provideDetails() {
		this.name = Read.read("name");
		while(name.isEmpty()) {
			System.err.print("Name cannot be null");
			name = Read.read("name");
		}
		this.address = Read.read("address");
		while(address.isEmpty()) {
			System.err.print("Address cannot be null");
			address = Read.read("address");
		}
		this.birthDate = null;
		try {
			this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("birthDate"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	boolean checkTransaction() {
		if (this.name == null || this.address == null || this.birthDate == null)
			return false;
		return true;

	}

	@Override
	void printErrorMessage() {
		if (!checkTransaction())
			System.err.println("Null data was given for create bank client profile transaction");

	}

	@Override
	void executeTransaction() {
		BankClientProfile bankClientProfile = new BankClientProfileConcrete(name, address, birthDate);
		this.bankClientProfile = bankClientProfile;
	}

}
