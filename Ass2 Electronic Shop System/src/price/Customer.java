class Customer {
  private String nameCust;
  private double Salary;
  
  public Customer(String name, double sal) {
    nameCust = name;
    Salary = sal;
  }
  
  public String getName() {
    return nameCust;
  }
  
  public double getSalary() {
    return Salary;
  }
  
  public String toString() {
    return "The customer's name is Simon with salary RM" + Salary + ".";
  }
}
