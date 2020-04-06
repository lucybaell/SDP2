package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.Calendar;
import java.util.Date;

/**
 * holds the name, address and dob of the BankClient
 *
 */
abstract public class BankClientProfile {

	public String name;
	public String address;
	public Date birthDate;

	public BankClientProfile(String name, String address, Date birthDate) {

		if (name == null)
			System.err.println("Error create profile transaction - name");
		else {
			if (fakeStringCheck(name))//only add it if it passes check
				this.name = name;
		}
		if (address == null)
			System.err.println("Error create profile transaction - address");
		else {
			if (fakeStringCheck(address))//only add it if it passes check
				this.address = address;
		}

		if (birthDate == null)
			System.err.println("Error create profile transaction - birthdate");
		else {
			if (dateNotAfterTodayCheck(birthDate))//only add it if it passes check
				this.birthDate = birthDate;
		}

	}

	/**
	 * 3.Cyber Security returns false if the string starts with '$' or ends in
	 * '.'(dot)
	 * 
	 * @param string
	 * @return
	 */
	public boolean fakeStringCheck(String string) {

		if (!string.isEmpty()) {
			if (string.charAt(0) == '$') {
				System.err.print("Fake name or address was given for Client Profile\n");
				return false;
			}
			if (string.charAt(string.length() - 1) == '.') {
				System.err.print("Fake name or address was given for Client Profile\n");
				return false;
			}
		}
		return true;
	}

	/**
	 * 3.Cyber Security returns false if date is after today
	 * 
	 * @param date
	 * @return
	 */
	public boolean dateNotAfterTodayCheck(Date date) {

		Date today = Calendar.getInstance().getTime();

		if (date != null) {
			if (date.compareTo(today) > 0) {
				System.err.print("Fake Date was given for Client Profile\n");
				return false;
			}
		}
		return true;
	}

	public void toPrint() {

		System.out.println("name = " + name);
		System.out.println("address = " + address);
		System.out.println("birthDate = " + birthDate);
	}
}
