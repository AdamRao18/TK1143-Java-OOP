
public class Student {
	
	private String studName;
	private String studID;
	
	public Student(String sn, String sid) {
		studName = sn;
		studID = sid;
	}
	
	public String getStudName() {
		return studName;
	}
	
	public String StudID() {
		return studID;
	}
	
	public String toString() {
		return studName + " " + "(" + studID + ")";
	}
}
