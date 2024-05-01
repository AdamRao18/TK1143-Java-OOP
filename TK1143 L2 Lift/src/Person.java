
public class Person {
	
	private String name;
	private int weight;
	
	public Person(String nm, int wg) {
		name = nm;
		weight = wg;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return name + " " + weight ;
	}
}