import java.util.ArrayList;
import java.util.Collections;

public class Bank {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
		
		list.add(new CreditCardAccount(-293487, "Evie"));
		list.add(new CheckingAccount(1000, "Dennis"));
		list.add(new CheckingAccount(1500, "Sally"));
		list.add(new CreditCardAccount(-293487, "Sam"));
		list.add(new CheckingAccount(2534, "George"));
		list.add(new CheckingAccount(10000, "Alice"));
		list.add(new CreditCardAccount(-29387, "Jim"));
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			BankAccount account = list.get(i);
			System.out.println(account.getName() + " " + 
			account.getAccountNumber() + ": " + account.getBalance());
		}
		
		
		

	}

}
