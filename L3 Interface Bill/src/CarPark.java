
class CarPark implements Bill {
	private String location;
	private String houseType;
	private User bill;
	
	public CarPark(String c,String loc) {
		houseType = c;
		location = loc;
	}
	
	public void getBill(User u) {
		bill = u;
		System.out.println(toString());
		
			if(bill.getMonthlySal()>15000) 
				System.out.println("The user's name is " + bill.getName() + " " + houseType + " type house gets a free car park.");
			
			else
				System.out.println(bill.getName() + ", need to pay for the car park");
				
	}
	
	public String toString() {
		return "House type is " + houseType + " with location is at " + location;
	}
}
