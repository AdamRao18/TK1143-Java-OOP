
public class Chair {
    private double loadCapacity;
    private String color;

    public Chair(double loadCapacity, String color) {
    	
        this.loadCapacity = loadCapacity;
        this.color = color;
    }

    public double getLoadCapacity() {
        
    	return loadCapacity;
    }

    public String getColor() {
        
    	return color;
    }

    public String toString() {
        
    	return "\n" + "The chair can bear up to " + getLoadCapacity() + "kg and its color is " + getColor();
    }
}
