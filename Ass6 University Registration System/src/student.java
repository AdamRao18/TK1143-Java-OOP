
public class student {
	private String name;
	private String matric;
	private int yofStudy;

	public student(String n, String m, int y) {
		name = n;
		matric = m;
		yofStudy = y;
	}

	public String getName() {
		return name;
	}

	public String getMatric() {
		return matric;
	}

	public int getYear() {
		return yofStudy;
	}

	public String toString() {
		return	getName() + "(" + getMatric() + ") " + "Year " + getYear();
	}
}
