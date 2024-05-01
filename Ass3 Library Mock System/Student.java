public class Student {
    private String name;
    private String matric;

	
	public Student(String name, String matric) {
		this.name=name;
		this.matric=matric;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMatric() {
		return matric;
	}
	
	public String toString() {
		return name + "("+matric+")";
	}
}