
import java.util.Scanner;
import java.text.DecimalFormat;

public class AssessmentEvaluationApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.0");
		
		//Number of students
		int numStud = scan.nextInt();
		Student[] student = new Student[numStud];
		AssignmentEvaluation assignmentEvaluation[] = new AssignmentEvaluation[numStud];
		ProjectEvaluation projectEvaluation[] =  new ProjectEvaluation[numStud];
		
		
		for (int i = 0; i < numStud; i++) {
			//Insert name
			scan.nextLine();
			String name = scan.nextLine();
	       
			//Insert ID
			String id = scan.nextLine();
	        	     		
			//Insert total marks for assignments (out of 120)
			double totalAssignmentMarks = scan.nextDouble();
	        
			//Insert project presentation marks (out of 20)
			double presentationMarks = scan.nextDouble();
	        
			//Insert project report marks (out of 20)
			double reportMarks = scan.nextDouble();
	    
			// Create objects 
			assignmentEvaluation[i] = new AssignmentEvaluation("TK1143", 6, totalAssignmentMarks);
			projectEvaluation[i] = new ProjectEvaluation("TK1143", presentationMarks, reportMarks);
			student[i] = new Student(name, id);		
			
			double assignment = assignmentEvaluation[i].evaluation();
			double project = projectEvaluation[i].evaluation();
			double totalAssessmentMarks = assignment + project;
			//Calculation to get assessmentPercentage over 70%
			double assessmentPercentage = totalAssessmentMarks / 60 * 70;
			
			// Print the student's overall marks
			System.out.println(student[i].toString());
			System.out.println("Total assessment marks (out of 60): " + df.format(totalAssessmentMarks));
			System.out.println("Project Status: " + projectEvaluation[i].projectStatus() );
			System.out.println("Assessment marks (out of 70%): " + df.format(assessmentPercentage) + "%");           
            System.out.println();   
            
			// Print a student get high Mark in Project assessment (Status =  Excellent or Total mark > 30)
			projectEvaluation[i].setBestStudent(student[i]);
        }	
	}
}
