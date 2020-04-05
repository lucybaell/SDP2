package gradedGroupProject.nonPrincipledDesign.v1;

import java.util.concurrent.atomic.AtomicInteger;

abstract public class BankAccount {

	public static final AtomicInteger accountCount = new AtomicInteger(0);

	public int accountNumber;
	public String accountType;
	public boolean accountVerified;
	public double accountBalance;

	public BankAccount() {

		this.accountNumber = accountCount.incrementAndGet();
		this.accountVerified = false;
	}
}