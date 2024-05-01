
public class ProjectEvaluation extends AssessmentEvaluation{
	
	private double presentationMarks;
	private double reportMarks;
	private Student bestStudent;
	private double totalMarks;
	
	public ProjectEvaluation(String sub, double present, double report) {
		super(sub);
		presentationMarks = present;
		reportMarks = report;
	}
	
	public double getTotalMarks() {
		return totalMarks;
	}
	
	public double evaluation() {
		return totalMarks = presentationMarks + reportMarks;
	}
	
	public void setBestStudent (Student student) {
		bestStudent = student;
		if(totalMarks > 30)
			System.out.println(bestStudent.toString() + " got Excellent project\n");
	}
public String projectStatus() {
		if(totalMarks > 30)
			return "Excellent";
		else if(totalMarks >= 24 && totalMarks <= 30) 
			return "Good";
		else if(totalMarks >= 16 && totalMarks <= 23) 
			return "Satisfactory";
		else
			return "Fail";
	}
	
	public double getPresentationMarks() {
		return presentationMarks;
	}
	
	public double getReportMarks() {
		return reportMarks;
	}
}

