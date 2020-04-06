package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * abstract class for BankAccount object
 *
 */
abstract public class BankAccount {

	public static final AtomicInteger accountCount = new AtomicInteger(0);//keep count of bank accounts and accountnumbers

	public int accountNumber;//holds each bank account number
	public String accountType;//savings or primary
	public boolean accountVerified;//true after BankAdmin verifies it
	public double accountBalance;//holds bank account money

	public BankAccount() {

		this.accountNumber = accountCount.incrementAndGet();//account numbers start at 1 and increment with each BankAccount
		this.accountVerified = false;
	}
}