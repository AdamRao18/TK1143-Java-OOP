import java.text.DecimalFormat;

public class BankAccount {
	DecimalFormat df = new DecimalFormat("0.00");
	
	private double balance;

	public double getBalance() {
		 return balance;
	}
	
	public BankAccount(double amount) {
		balance=amount;
	}
	
	public void deposit(double amount) {
		balance+=amount;
		
	}
	
	public void withdraw (double amount){
		balance-=amount;
		
	}
	
	
	public double calculateHibah() {
		
		return balance*0.035;
	}
	
	public void updateBalance(double hibah) {
		
System.out.println("New balance:" + " " + df.format(balance+hibah));
		
	}

}
