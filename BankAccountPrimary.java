package gradedGroupProject.nonPrincipledDesign.v1;
/**
 * for primary accounts
 *
 */
public class BankAccountPrimary extends BankAccount{

	public BankAccountPrimary () {
		super();
		this.accountType= "Primary";
		this.accountBalance = 100.00;
	}
}
