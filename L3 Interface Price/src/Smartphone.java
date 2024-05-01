
class SmartPhone extends Product{
    private String nameSP;
    private double priceSP;
    
    public SmartPhone(String type, String name, double price) {
        super(type);
        nameSP=name;
        priceSP=price;
    }
    
    public String toString() {
    	return "The product is " + nameSP + ".";
    }
 
}
