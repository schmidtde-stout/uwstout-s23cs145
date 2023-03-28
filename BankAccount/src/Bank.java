import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

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
		
		HashMap<String, BankAccount> accountsByName = new HashMap<String,BankAccount>();
		for(BankAccount account : list) {
			String key = account.getName();
			accountsByName.put(key, account);
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the account holders name: ");
		String name = scanner.nextLine();
		BankAccount account = accountsByName.get(name);
		if (account == null) {
			System.out.println("Sorry, we have no account for " + name);
		}
		else {
			System.out.println("Welcome back " + name + ", your balance is " + account.getBalance());
		}
		scanner.close();
		

	}

}
