
public class MeetingRoom extends BookingRoom {

	private int numOfHour;
	private int typeOfStay;
 
	public MeetingRoom (String name,int nOP,int nOH,int tOS) {
		super (name,nOP);
		numOfHour = nOH;
		typeOfStay=tOS;
	}
 
	public int getTypeOfStay() {
		
		return typeOfStay;
	}
	
	public int getNumHour(){
		
		return numOfHour;
	}
	
	public double payment() {
		
		double total =0;
		if(typeOfStay==1) {
			
			total=numOfHour*250;
		}
		else if (typeOfStay==2) {
    
			total=numOfHour*150;
		}
		if(total>1000) {
			
			total=total-(total*0.05);
		}
   
		return total;
	}
}
