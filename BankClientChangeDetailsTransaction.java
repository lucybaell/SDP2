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
		bankClient.bankClientCridentials.username = username;
		bankClient.bankClientCridentials.password = password;
		bankClient.bankClientProfile.name= name;
		bankClient.bankClientProfile.address= address;
		bankClient.bankClientProfile.birthDate= birthDate;
		}
	}


}
