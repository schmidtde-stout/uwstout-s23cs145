import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest extends BankAccount {

	// this is a way to "fake out" the abstract class for the purpose of unit testing
	public BankAccountTest(double startingBalance, String name) {
		super(startingBalance, name);
	}
	

	@Override
	public void endOfMonth() {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testBankAccountConstruction() {
		
      BankAccount chippysAccount = new BankAccountTest(1000, "Chippy");
      chippysAccount.endOfMonth();
      assertEquals(chippysAccount.getName(), "Chippy");
      assertTrue(chippysAccount.getAccountNumber() <= 50000);
      assertTrue(chippysAccount.getAccountNumber() > 0);
      assertEquals(chippysAccount.getBalance(), 1000);
	}

	@Test
	void testBankAccountDeposit() {
      BankAccount chippysAccount = new BankAccountTest(1000, "Chippy");
      chippysAccount.deposit(500);
      assertEquals(chippysAccount.getBalance(), 1500);
	}

	@Test
	void testBankAccountWithdrawal() {
      BankAccount chippysAccount = new BankAccountTest(1000, "Chippy");
      chippysAccount.withdraw(123);
      assertEquals(chippysAccount.getBalance(), 877);
	}


}
