
import java.text.DecimalFormat;
class Astro extends Utility implements Bill{
	private String nameAs;
	private double billpayAs;
	private User bill;
	
	static DecimalFormat df = new DecimalFormat("0.00");
	
	public Astro(String name, String nameAs, double billpayAs) {
		super(name);
		this.nameAs = nameAs;
		this.billpayAs = billpayAs;
	}
	
	public void getBill(User bil) {
		bill = bil;
		System.out.println(toString());
		
		if(billpayAs>300) 
			System.out.println("The user's name is " + bill.getName() + ", pay bil RM" + df.format(0.7*billpayAs) + " with discount 30%.");
		
		else
			System.out.println("The user's name is " + bill.getName() + ". Sorry,No discount");
	}
	
	public String toString() {
		return "The utility is " + nameAs + " with bill RM" + df.format(billpayAs);
	}
	
}