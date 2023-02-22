import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest extends BankAccount {

	private BankAccount account;

	// we changed our test to use a default constructor
	// JUnit has some sensitive boundaries when you start
	// creating JUnit tests with non-default constructors
	public BankAccountTest() {
		super(1000);
	}

	@Override
	public void endOfMonth() {
		// TODO Auto-generated method stub
	}

	@BeforeEach
	void setUp() {
		account = new BankAccountTest();
	}

	@Test
	void testBankAccountConstruction() {
		assertEquals(account.getName(), "Charity");
		assertTrue(account.getAccountNumber() <= 50000);
		assertTrue(account.getAccountNumber() > 0);
		assertEquals(account.getBalance(), 1000);
	}

	@Test
	void testBankAccountDeposit() {
		account.deposit(500);
		assertEquals(account.getBalance(), 1500);
	}

	@Test
	void testBankAccountWithdrawal() {
		account.withdraw(123);
		assertEquals(account.getBalance(), 877);
	}

}
