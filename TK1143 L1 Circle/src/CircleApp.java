
import java.util.Scanner;
import java.text.DecimalFormat;

public class CircleApp {
  
  public static void main(String[] args) {
    
	  Scanner sc = new Scanner (System.in);
	  DecimalFormat df = new DecimalFormat ("0.00");
  
  
	  double radius = sc.nextDouble();
  
	  if(radius >=0.0 && radius <= 500.0) {
    
		  Circle circleshape = new Circle (radius);
		  circleshape.displayinfo(radius);
	  }   
  }
}
