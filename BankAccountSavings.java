package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * for savings BankAccount
 * @author danielmason
 *
 */
public class BankAccountSavings extends BankAccount {

	public BankAccountSavings () {
		super();
		this.accountType= "Savings";
		this.accountBalance = 100.00;
	}
}
