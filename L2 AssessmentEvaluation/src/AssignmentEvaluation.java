
public class AssignmentEvaluation extends AssessmentEvaluation{
	
	private int numAssignment;
	private double totalAssignmentMarks;
	
	public AssignmentEvaluation(String sub, int num, double total) {
		super(sub);
		numAssignment = num;
		totalAssignmentMarks = total;
	}
	
	public double evaluation() {
		return totalAssignmentMarks/numAssignment;
	}
	
	public int getNumAssignment() {
		return numAssignment;
	}
	
	public double getTotalAssignmentMarks() {
		return totalAssignmentMarks;
	}
}