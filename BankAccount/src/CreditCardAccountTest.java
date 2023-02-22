import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CreditCardAccountTest {

	@Test
	void testEndOfMonth() {
		CreditCardAccount account = new CreditCardAccount(0, "Dennis");
		account.withdraw(1000); // charge transaction
		account.endOfMonth();
		double difference = Math.abs(account.getBalance() + 1016.67);
		assertTrue(difference < 0.01);
	}

}
