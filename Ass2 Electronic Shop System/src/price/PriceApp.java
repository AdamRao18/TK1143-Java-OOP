public class PriceApp {

	public static void main(String[] args) {
			SmartPhone sp = new SmartPhone("SmartPhone","IPhone 14 ProMax",5500.00);		
			Laptop l = new Laptop("Laptop","Lenovo Yoga", 6000.00);
			Car c=new Car("BMW",200000);
						
			Customer c1 = new Customer("Sally", 3000.00);
			Customer c2 = new Customer("Aaron", 8000.00);	
			Customer c3 = new Customer("Simon", 10000.00);	
			
			
			sp.getPrice(c1);
			l.getPrice(c2);	
			c.getPrice(c3);
		 }
}
