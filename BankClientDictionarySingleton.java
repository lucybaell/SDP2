package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.ArrayList;

/**
 * 2.System Design
 * Applies singleton rule, creates one list of BankClients and can only be instantiated once
 *
 */
public class BankClientDictionarySingleton {

	private ArrayList<BankClient> bankClients;
	private static BankClientDictionarySingleton singletonInstance;

	/**
	 * Applies the singleton rule by only calling the private constructor if it has
	 * not been done before by initialising the instance variable
	 * 
	 */
	private BankClientDictionarySingleton() {
		bankClients = new ArrayList<>();
	}

	public static BankClientDictionarySingleton getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new BankClientDictionarySingleton();
		}
		return singletonInstance;
	}

	/**
	 * 
	 * @return - ArrayList of BankClients
	 */
	public ArrayList<BankClient> getBankClients() {
		return this.bankClients;
	}

	/**
	 * Adds a bank client to the list
	 * 
	 * @param client
	 */
	public void addBankClient(BankClient bankClient) {
		if (bankClient != null) {
			if (!bankClients.contains(bankClient)) {
				bankClients.add(bankClient);
			}
		}
	}

	/**
	 * prints all the bank clients details
	 * 
	 * @return
	 */
	public void printBankClients() {

		for (BankClient bankClient : bankClients) {
			if (bankClient != null) {
				bankClient.toPrint();
			}
		}
	}

	public void printBankClient(int index) {

		getBankClient(index).toPrint();
	}

	/**
	 * Returns the index of the bank client who matches the passed in username and
	 * password -1 if search failed
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int searchBankClient(String username, String password) {
		for (int i = 0; i < bankClients.size(); i++) {
			if (bankClients.get(i).bankClientCridentials.username.equals(username)) {
				if (bankClients.get(i).bankClientCridentials.password.equals(password)) {
					return i;
				}
			}
		}
		// if the search did not return a value
		return -1;
	}

	/**
	 * 
	 * @return - int size of the bank clients list
	 */
	public int getSize() {
		return bankClients.size();
	}

	/**
	 * returns a specified bank client
	 * 
	 * @param index
	 * @return
	 */
	public BankClient getBankClient(int index) {
		if (index >= 0 && index < bankClients.size()) {
			return bankClients.get(index);
		}
		return null;
	}

	/**
	 * Removes a client from the list
	 * 
	 * @param index
	 */
	public void deleteBankClient(int index) {
		bankClients.remove(getBankClient(index));
	}

}