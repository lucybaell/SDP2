package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankClientChangeDetailsTransaction {

	public BankClientChangeDetailsTransaction(BankClient bankClient) {

		String username = Read.read("new username");
		String password = Read.read("new password");
		
		String name = Read.read("new name");
		String address = Read.read("new address");

		Date birthDate = null;
		try {
			birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("new birthDate"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		if (name == null || address == null || birthDate == null || username == null || password == null)
			System.err.println("Error change details transaction");

		else {
		bankClient.username = username;
		bankClient.password = password;
		bankClient.name= name;
		bankClient.address= address;
		bankClient.birthDate= birthDate;
		}
	}


	
	
	/* THIS IS FROM THE BankClient class
	 public void changeClientDetails(String name, String address, Date birthDate, String username, String password) {

		if (name == null || address == null || birthDate == null || username == null || password == null)
			System.err.println("Error change details transaction");

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
			this.username = username;
			this.password = password;
		}
	}
	 
	 */
}
