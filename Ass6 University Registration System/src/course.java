
public class course {
	private String cCode;
	private int maxStu;
	private String cName;
	private student stu;
	private int numEnrolled;
	private student[] enrolledStudents;

	public course(String c, String n, String m) {
		cCode = c;
		cName = n;
		maxStu = Integer.parseInt(m);
		this.numEnrolled = 0;
		int limStu=maxStu+1;
		this.enrolledStudents = new student[limStu];
	}

	public String getCode() {
		return cCode;
	}

	public String getName() {
		return cName;
	}

	public int getMax() {
		return maxStu;
	}

	public student getStudent() {
		return stu;
	}

	public boolean enrolledBy(student student) {
	    
        if (numEnrolled == (enrolledStudents.length)) {
            return false;
        }else {
        enrolledStudents[numEnrolled] =  stu;
        numEnrolled++;
        return true;}
        }

	public String toString() {
		return getName() + "(" + getCode() + ")";
	}
}
