import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CheckingAccountTest {

	@Test
	void testCheckingAccountConstruction() {
		CheckingAccount account = new CheckingAccount(100, "Dennis");
		account.withdraw(10);
		assertEquals(account.getBalance(), 87.50);
	}

}
