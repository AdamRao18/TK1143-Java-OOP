
public class FixedChair extends Chair {
	
	private int row;
	private int column;
	private Person sitter;
	
	public FixedChair(double loadCapacity, String color, int row, int column) {
		
		super(loadCapacity,color);
		this.row = row;
		this.column = column;
	}

	public void setSitter(Person Sitter) {
		
		this.sitter = sitter;
	}
	
	public Person getSitter () {
	
		return sitter;
	}
	
	public void occupiedBy(Person person ) {
	
		if (person.getWeight() <= 60) {
	    
			System.out.println(this.toString() + "\nThe chair can bear " + person.getName() + " that has a weight of " + person.toString());
	    } 
		else {
	    
			System.out.println(this.toString() + "\nThe chair cannot bear " + person.getName() + " that has weight of " + person.toString());
	    }
	}

	public String toString() {
		
		return super.toString() + "\nLocation of chair is row " + row + ", column " + column;
	}
}

