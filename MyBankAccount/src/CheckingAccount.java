
/**
 * CheckingAccount simulates a checking account that inherits all the features
 * and attributes of a BankAccount but adds withdraw fee and tracks the next
 * available check number
 * 
 * @author schmidtde
 *
 */
public class CheckingAccount extends BankAccount {
	private int nextCheckNumber;

	/**
	 * CheckingAccount default constructor, defaults balance to zero and starting
	 * checking number to 1000
	 */
	public CheckingAccount() {
		super(0);
		nextCheckNumber = 1000;
	}

	/**
	 * Checking account constructor that mirrors the base class constructor
	 * 
	 * @param startingBalance This is the starting balance of the account (initial
	 *                        deposit)
	 * @param customerName    The name of the customer who owns the account
	 */
	public CheckingAccount(double balance, String name) {
		super(balance, name);
		nextCheckNumber = 1000;
	}

	/**
	 * Perform a withdraw transaction with an added fee Note: negative withdraws are
	 * disallowed
	 * 
	 * @param amount The dollar amount to be withdrawn.
	 */
	public void withdraw(double amount) {
		if (amount > 0) {
			// do something else
			super.withdraw(amount + 2.50);
		}

	}
	
	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

}
