
import java.util.*;
import java.text.DecimalFormat;

public class MyPrintCard {
	DecimalFormat df = new DecimalFormat("0.00");
	
	private double balance;
  
	public  MyPrintCard() {
		this.balance=10.00;    
	}
  
	
	public  double getBalance() {
		return this.balance;
	}
  
	
	public void topupCard(double amt) {
		this.balance+=amt;
	}
  
	public boolean payService(double amt) {
		if (this.balance-amt >= 5) {
			this.balance-=amt;
			return true;
		}
		return false;
    	}
  
	
	public String toString() {
		return "RM" + df.format(this.balance);
	}
}
