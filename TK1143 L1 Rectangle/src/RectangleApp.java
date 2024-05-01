
import java.util.*;
import java.text.*;

public class RectangleApp {
	
  public static void main(String[] args) {
	  
    DecimalFormat df = new DecimalFormat ("0.00"); 
    Scanner sc = new Scanner(System.in);
    
    
    double w1 = sc.nextDouble();     
    double h1 = sc.nextDouble();
    
    double w2 = sc.nextDouble();    
    double h2 = sc.nextDouble();
    
    Rectangle rect1 = new Rectangle(w1,h1);
    Rectangle rect2 = new Rectangle(w2,h2);   
    System.out.println(df.format(rect1.getWidth())+ " "+ df.format(rect1.getHeight()) + " "+ df.format(rect1.getArea())+ " " + df.format(rect1.getPerimeter()));     
    System.out.println(df.format(rect2.getWidth())+ " "+ df.format(rect2.getHeight()) + " "+ df.format(rect2.getArea())+ " " + df.format(rect2.getPerimeter()));
  }
}
