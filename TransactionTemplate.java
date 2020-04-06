package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * this class is used to for the template pattern. Each step is defined for a
 * transaction as an abstract function and a concrete transaction method calls
 * them step by step
 * 
 */
 public abstract class TransactionTemplate {

	public void transaction() {
		provideDetails();
		checkTransaction();
		printErrorMessage();
		executeTransaction();
	}

	abstract void provideDetails();

	abstract boolean checkTransaction();

	abstract void printErrorMessage();

	abstract void executeTransaction();
}
