
import java.text.DecimalFormat;
class Electricity extends Utility implements Bill{
	private String nameEl;
	private double billpayEl;
	private User bill;
	static DecimalFormat df = new DecimalFormat("0.00");
	
	public Electricity(String name, String nameEl, double billpayEl) {
		super(name);
		this.nameEl = nameEl;
		this.billpayEl = billpayEl;
	}
	
	public void getBill(User bill) {
		this.bill = bill;
		System.out.println(toString());
		
		if(billpayEl>400) 
			System.out.println("The user's name is " + bill.getName() + ", pay bil RM" + df.format(0.5*billpayEl) + " with discount 50%.");
		
		else
			System.out.println("The user's name is " + bill.getName() + ". Sorry,No discount");
		
	}
	
	public String toString() {
		return "The utility is " + nameEl + " with bill RM" + df.format(billpayEl);
	}
}
