
public class CreditCardAccount extends BankAccount {
	final private double INTEREST_RATE = 0.20; // 20% APR

	public CreditCardAccount(double startingBalance, String name) {
		super(startingBalance, name);
	}

	@Override
	public void endOfMonth() {
		double accruedInterest = Math.abs(getBalance() * INTEREST_RATE / 12.0);
		withdraw(accruedInterest);
	}

}
