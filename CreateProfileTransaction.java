package gradedGroupProject.nonPrincipledDesign.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateProfileTransaction {

	public String name;
	public String address;
	public Date birthDate;

	public void createProfile(BankClient bankClient) {
		String name = Read.read("name");
		String address = Read.read("address");

		Date birthDate = null;
		try {
			birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(Read.read("birthDate"));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		BankClientProfile bankClientProfile = new BankClientProfileConcrete(name, address, birthDate);
//*************************
		bankClient.name = name;
		bankClient.address = address;
		bankClient.birthDate = birthDate;
	}

}
