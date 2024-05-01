
import java.text.DecimalFormat;
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		double amount = sc.nextDouble();
		BankAccount balance = new BankAccount(amount);
		
		System.out.println("Previous balance:" + " " + df.format(balance.getBalance()));
		
		int num=sc.nextInt();
		if (num==1) {
			double deposit = sc.nextDouble();
			balance.deposit(deposit);
			
		}
		
		else if(num==2) {
			double withdraw = sc.nextDouble();
			balance.withdraw(withdraw);
			
		}
		
		else {
			System.out.println("Invalid Operation");
			
		}
		
		double hibah = balance.calculateHibah();
		balance.updateBalance(hibah);
		
		System.out.println("Hibah earned:" + " " + df.format(hibah));
	}
}

