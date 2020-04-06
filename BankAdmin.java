package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * BankAdmin class, holds the name, clients that bank accounts need verified and
 * the bank account numbers
 *
 */
public class BankAdmin extends Person {

	public String name = "Y";//bank admin name

	public List<BankClient> bankClientsToVerify;//bank clients with accounts that need verified
	public List<Integer> accountNumbersToVerify;//bank accounts that need verified

	public BankAdmin() {

		this.bankClientsToVerify = new ArrayList<BankClient>();//Initialises the array
		this.accountNumbersToVerify = new ArrayList<Integer>();//Initialises the array
	}
}