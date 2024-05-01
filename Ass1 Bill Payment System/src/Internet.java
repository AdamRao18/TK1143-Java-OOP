
import java.text.DecimalFormat;
    class Internet extends Utility implements Bill {
       private String nameIT;
       private double billpayIT;
       private User bill;
       static DecimalFormat df = new DecimalFormat("0.00");
 
       public Internet(String name,String nameIt, double payBill) {
          super(name);
          nameIT = nameIt;
          billpayIT = payBill;
       }
 
       public void getBill(User b) {
           bill = b;
           System.out.println(toString());
  
           if(billpayIT>200) 
              System.out.println("The user's name is " + bill.getName() + ", pay bil RM" + df.format(0.95*billpayIT) + " with discount 5%.");
  
           else
              System.out.println("The user's name is " + bill.getName() + ". Sorry,No discount");
       }
 
 
       public String toString() {
          return "The utility is " + nameIT + " with bill RM" + df.format(billpayIT);
       }
  } 
