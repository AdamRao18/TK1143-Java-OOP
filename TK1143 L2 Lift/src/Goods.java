
public class Goods {
	
	private String name;
	private int weight;
	
	public Goods (String n, int w) {
		name= n;
		weight = w;
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