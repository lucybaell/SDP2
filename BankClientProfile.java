package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.Date;

public  class BankClientProfile {

	public String name;
	public String address;
	public Date birthDate;

	public BankClientProfile(String name, String address, Date birthDate) {

		if (name == null || address == null || birthDate == null)
			System.err.println("Error create profile transaction");

		else {

			this.name = name;
			this.address = address;
			this.birthDate = birthDate;
		}
	}

	public void toPrint() {

		System.out.println("name = " + name);
		System.out.println("address = " + address);
		System.out.println("birthDate = " + birthDate);
	}
}
