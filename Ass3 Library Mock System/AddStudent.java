import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddStudent extends JFrame implements ActionListener {
	private JLabel lblname, lblmatric,lbltextarea;
	private JTextField nameField;
	private JTextField matricField;
	private JButton addButton,listButton;
	static Student[] students;
	private int currentIndex;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	public AddStudent() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		setTitle("Add Student Info");
		setVisible(true);
		setSize(500,250);
		
		// Create components
		lblname = new JLabel("Name:");
		lblmatric = new JLabel("Matric:");
		lbltextarea = new JLabel("Students:");
		nameField = new JTextField(20);
		matricField = new JTextField(20);
		addButton = new JButton("Add");
		listButton = new JButton("List");
		
		
		textArea = new JTextArea(5,40);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		addButton.addActionListener(this);
		listButton.addActionListener(this);
		
		students = new Student[5];
		currentIndex = 0;

		// Add components to the frame
		JPanel inputPanel = new JPanel(new GridLayout(2, 2));
		inputPanel.add(lblname);
		inputPanel.add(nameField);
		inputPanel.add(lblmatric);
		inputPanel.add(matricField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(listButton);

		JPanel listPanel = new JPanel(new BorderLayout());
		listPanel.add(lbltextarea, BorderLayout.NORTH);
		//listPanel.add(lbltextarea);
		//textArea = new JTextArea(5,40);
		//scrollPane = new JScrollPane(textArea);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scrollPane);
		
		pane.add(inputPanel, BorderLayout.NORTH);
		pane.add(buttonPanel, BorderLayout.CENTER);
		pane.add(listPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj==addButton) {
			// Get the input values
			String name = nameField.getText();
			String matric = matricField.getText();

			// Create a new student object
			Student newStudent = new Student(name, matric);

			// Add the student to the array
			students[currentIndex] = newStudent;
			currentIndex++;

			// If the array is full, double its size
			if (currentIndex >= students.length) {
				Student[] newStudents = new Student[students.length * 2];
				System.arraycopy(students, 0, newStudents, 0, students.length);
				students = newStudents;
			}

			// Clear the input fields
			nameField.setText("");
			matricField.setText("");
		}
		if(obj==listButton) {

			for (Student student : students) {
				if (student != null) {
					//textArea.append(student.toString() + "\n");
					textArea.append("Name : " + student.getName() + " (" + student.getMatric() + ") \n" );
				}
			}
		}
	}
	
	public static Student[] getArrayStudent() {
		return students;
	}
}
