package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.Date;

abstract public class BankClientProfile {

	public String name;
	public String address;
	public Date birthDate;

	public BankClientProfile(String name, String address, Date birthDate) {

		if (name == null )
			System.err.println("Error create profile transaction - name");
		else
			this.name = name;
		if (address == null)
			System.err.println("Error create profile transaction - address");
		else
			this.address = address;
		if (birthDate == null)
			System.err.println("Error create profile transaction - birthdate");
		else {
			this.birthDate = birthDate;

		}
	}

	public void toPrint() {

		System.out.println("name = " + name);
		System.out.println("address = " + address);
		System.out.println("birthDate = " + birthDate);
	}
}
