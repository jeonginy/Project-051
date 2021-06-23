package prj051;

public class BankAccountTest {
	public static void main(String[] args) {
		
		BankAccount1 myAccount = new BankAccount1();
		myAccount.deposit(100);
		myAccount.withdraw(40);
		int bal = myAccount.getBalance();
		System.out.println( "Your balance is " + bal );
		double itr = myAccount.getInterest();
		System.out.println( "The interest is " + itr );
		
	}

}

class BankAccount1 {
	int balance;
	double interestRate = 0.075;
	
	private double Balance;
	private double interst;
	
	public void money() {
		
	}
	void deposit(int amount) {
		balance += amount;
	}
	
	void withdraw(int amount) {
		balance -= amount;
		if( balance < 0 ) {
			System.out.println("Your balance is not available for withdraw");
			System.out.println("Exit");
			System.exit(01);
		}
	}
	
	int getBalance() {
		return balance;
	}
	double getInterest() {
		double interest = balance * interestRate;
		return interest;
	}
	
}


