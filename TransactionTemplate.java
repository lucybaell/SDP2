package gradedGroupProject.nonPrincipledDesign.v1;

/**
 * 2. System Design
 * this class is used to for the template pattern. Each step is defined for a
 * transaction as an abstract function and a concrete transaction method calls
 * them step by step
 * 
 */
 public abstract class TransactionTemplate {

	 /**
	  * the concrete method calling the abract transactin functions
	  */
	public void transaction() {
		provideDetails();
		checkTransaction();
		printErrorMessage();
		executeTransaction();
	}

	/**
	 * function asks user for data needed
	 */
	abstract void provideDetails();

	/**
	 * checks the data provided and returns true if it works
	 * @return
	 */
	abstract boolean checkTransaction();

	/**
	 * prints errors if checkTransaction false
	 */
	abstract void printErrorMessage();

	/**
	 * executes transaction
	 */
	abstract void executeTransaction();
}
