import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void testBankAccountConstruction() {
      BankAccount chippysAccount = new BankAccount(1000, "Chippy");
      assertEquals(chippysAccount.getName(), "Chippy");
      assertTrue(chippysAccount.getAccountNumber() <= 50000);
      assertTrue(chippysAccount.getAccountNumber() > 0);
      assertEquals(chippysAccount.getBalance(), 1000);
	}

	@Test
	void testBankAccountDeposit() {
      BankAccount chippysAccount = new BankAccount(1000, "Chippy");
      chippysAccount.deposit(500);
      assertEquals(chippysAccount.getBalance(), 1500);
	}

	@Test
	void testBankAccountWithdrawal() {
      BankAccount chippysAccount = new BankAccount(1000, "Chippy");
      chippysAccount.withdraw(123);
      assertEquals(chippysAccount.getBalance(), 877);
	}

}
