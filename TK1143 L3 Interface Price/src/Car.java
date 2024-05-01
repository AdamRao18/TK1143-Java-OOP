
class Car implements Price{
    private String brand;
    private double priceCar;
    private Customer buy;
    
    public Car(String brand, double price){
    this.brand=brand;
    priceCar=price;
    }
    
    public void getPrice(Customer customer){
        buy=customer;
        System.out.println(toString());
        
        if(buy.getSalary()>8000){
            System.out.println("The customer's name is " + buy.getName() + " with salary RM" + buy.getSalary() + " can buy this car.");
            System.out.println("Your salary is higher than the price's car.");
        }
        
    }
    
    public String toString() {
    	return "The car brand is " + brand + " "+"with price RM" + priceCar + ".";
    }
}
