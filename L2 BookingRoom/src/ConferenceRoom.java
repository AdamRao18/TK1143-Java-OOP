
public class ConferenceRoom extends BookingRoom {

	private int typeOfPackage;
	private int merchandise;
 
	public ConferenceRoom (String name,int nOP,int tOP,int merch) {
		
		super (name,nOP);
		typeOfPackage=tOP;
		merchandise=merch;
	}
 
	public double payment() {
		
		double total=0;
		if(typeOfPackage==1) {
			
			total=4500.00;
		}
		else if (typeOfPackage==2) {
			
			total=3000.00;
		}
		if(merchandise==1) {
			
			total=total+10* super.payment();
		}
		
		return total;
	}
}
