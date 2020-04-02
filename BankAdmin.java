package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;
import java.util.List;

public class BankAdmin extends Person {

	public String name = "Y";

	public List<BankClient> bankClientsToVerify;
	public List<Integer> accountNumbersToVerify;

	public BankAdmin(){

		this.bankClientsToVerify = new ArrayList<BankClient>();
		this.accountNumbersToVerify = new ArrayList<Integer>();
	}
}
