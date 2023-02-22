import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreditCardAccountTest {

	@Test
	void testEndOfMonth() {
		CreditCardAccount account = new CreditCardAccount(0, "Dennis");
		account.withdraw(-1000);
		account.endOfMonth();
		assertEquals(account.getBalance(), -1016.67);
	}

}
