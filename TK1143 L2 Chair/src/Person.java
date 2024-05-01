
public class Person {
    private String name;
    private double weight;

    public Person(String name, double weight) {
    	
        this.name = name;
        this.weight = weight;
    }

    public void setWeight(double weight) {
        
    	this.weight = weight;
    }

    public String getName() {
        
    	return name;
    }

    public double getWeight() {
        
    	return weight;
    }

    public String toString() {
    	
    	return getWeight() + "kg!";
    }  
}
