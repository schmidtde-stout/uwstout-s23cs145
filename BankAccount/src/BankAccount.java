import java.util.Random;

/*
   BankAccount simulates a deposit account allowing the withdraw and 
   depositing of monies into an account.
*/
public abstract class BankAccount implements EndOfMonthActivities, Comparable<BankAccount> {

	@Override
	public int compareTo(BankAccount o) {
		// Returns a negative integer, zero, or a positive integer 
		// as this object is less than, equal to, or greater than the specified object.
		if (balance < o.getBalance()) {
			return -1;
		}
		else if(balance > o.getBalance()) {
			return 1;
		}
		return 0;
	}

	private double balance;
	private String name;
	private int accountNumber;

	/**
	 * Constructor for the BankAccount to setup inital balance
	 * 
	 * @param startingBalance This is the starting balance of the account (initial
	 *                        deposit)
	 * @param customerName    The name of the customer who owns the account
	 */
	public BankAccount(double startingBalance, String name) {
		balance = startingBalance;
		//name = name;
		this.name = name;
		assignAccountNumber();
	}

	/**
	 * Constructor for the BankAccount to setup inital balance. NOTE: Using this
	 * constructor will assign an owner as 'Charity'
	 * 
	 * @param startingBalance This is the starting balance of the account (initial
	 *                        deposit)
	 */
	public BankAccount(double startingBalance) {
		this(startingBalance, "Charity");
	}

	private void assignAccountNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(50000);
		randomNumber = randomNumber + 1;
		accountNumber = randomNumber;
	}

	/**
	 * Perform a deposit transaction
	 * 
	 * @param amount The dollar amount to be deposited.
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}

	/**
	 * Perform a withdraw transaction
	 * 
	 * @param amount The dollar amount to be withdrawn.
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}

	/**
	 * Accessor method for the balance variable
	 * 
	 * @return the current balance of the account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Accessor method for the accountNumber variable
	 * 
	 * @return the account number of the account
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Accessor method for the name variable
	 * 
	 * @return the account bearer name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Transfer money from this account object into the passed target account
	 * 
	 * @param targetAccount the destination bank account to receive money
	 * @param amount        the dollar amount to transfer
	 */
	public void transfer(BankAccount targetAccount, double amount) {
		this.withdraw(amount);
		targetAccount.deposit(amount);
	}
	


}