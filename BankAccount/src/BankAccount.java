import java.util.Random;

/*
   BankAccount simulates a deposit account allowing the withdraw and 
   depositing of monies into an account.
*/
public class BankAccount  {

   private double balance; 
   private String name;
   private int accountNumber;

   /**
     Constructor for the BankAccount to setup inital balance
     @param startingBalance This is the starting balance of the account (initial deposit)
     @param customerName The name of the customer who owns the account 
   */   
   public BankAccount(double startingBalance, String name) {
      balance = startingBalance;
      this.name = name;
      assignAccountNumber();
   }
   
   /**
     Constructor for the BankAccount to setup inital balance.  NOTE: Using this constructor
     will assign an owner as 'Charity'
     @param startingBalance This is the starting balance of the account (initial deposit)
   */   
   public BankAccount(double startingBalance) {
      this(startingBalance, "Charity");
   }

      
   private void assignAccountNumber() {
      Random random = new Random();
      int randomNumber = random.nextInt(50000);
      randomNumber = randomNumber + 1;
      accountNumber = randomNumber;      
   }
   
   
   /**
     Perform a deposit transaction
     @param amount The dollar amount to be deposited.
   */   
   public void deposit(double amount) {
      balance = balance + amount;
   }
   
   public void withdraw(double amount) {
      balance = balance - amount;
   }
   
   public double getBalance() {
      return balance;
   }
   
   public int getAccountNumber() {
      return accountNumber;
   }
   
   public String getName() {
      return name;
   }
   
   
   public void transfer(BankAccount targetAccount, double amount) {
      this.withdraw(amount);
      targetAccount.deposit(amount);
   }
   
}