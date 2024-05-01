
import java.text.DecimalFormat;
public class Circle {
  
  private double radius;
  
  DecimalFormat df = new DecimalFormat ("0.00");
  
    public Circle(double r) { 
    radius = r;     
    }  
    public double getRadius() {
    return radius ;
    }
    public double getArea() {
    return Math.PI*(radius*radius); 
  }
  public double getCircumference() {   
    return 2*Math.PI*radius;
  }
    public void displayinfo (double rad) {
      System.out.print("Radius:" + radius + " " + "The area will be " + df.format(getArea()) + " and the circumference is " + df.format(getCircumference()));
        
      }
}
