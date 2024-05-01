class Product implements Price {
  private String type;
  private Customer buy;
  
  public Product (String typ) {
    type = typ;
  }
  
  public void getPrice(Customer customer) {
    buy = customer;
    System.out.println(toString());
    
    if(buy.getSalary()>4000) {
      System.out.println("The customer's name is " + buy.getName() + " with salary RM" + buy.getSalary() + " can buy this product.");
      System.out.println("Your salary is higher than the price's product.\n");
    }
    
    else if(buy.getSalary()<4000) {
      System.out.println("The customer's name is " + buy.getName() + " with salary RM" + buy.getSalary() + " cannot buy this product.");
      System.out.println("The product price is more than your salary.\n");
    }
  }
  
  public String toString() {
    return "The product is " + type + ".";
  }
  
}
