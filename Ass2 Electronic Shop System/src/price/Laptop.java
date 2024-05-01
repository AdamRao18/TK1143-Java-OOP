class Laptop extends Product {
  private String nameL;
  private double priceL;
  
  public Laptop(String type,String name, double price) {
    super(type);
    nameL = name;
    priceL = price;
  }
  
  public String toString() {
    return "The product is " + nameL + ".";
  }
  
}
