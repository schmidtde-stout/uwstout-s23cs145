import org.junit.jupiter.api.Test;

class AnotherTest {

	@Test
	void test() {
		CheckingAccount checkingAccount = new CheckingAccount();
		//System.out.println(checkingAccount.toString());
		//System.out.println(checkingAccount);
		
		
		BankAccount account = checkingAccount;
		BankAccount bankAccount = new BankAccount(1000);
		if (bankAccount instanceof CheckingAccount) {
			CheckingAccount anotherChecking = (CheckingAccount)bankAccount;
			System.out.println(anotherChecking.getNextCheckNumber());
		}
		if (account instanceof CheckingAccount) {
			CheckingAccount anotherChecking = (CheckingAccount)account;
			System.out.println(anotherChecking.getNextCheckNumber());
		}		
		
		

		
	}

}
