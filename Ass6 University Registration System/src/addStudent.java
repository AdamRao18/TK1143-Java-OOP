
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class addStudent extends JFrame implements ActionListener {
	private JLabel header, lblname, lblmatric, yOfStudy;
	private JButton insertData, viewData;
	private JRadioButton y1, y2, y3, y4;
	private JRadioButton years[] = new JRadioButton[4];
	private JTextField txtName, txtMatric;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	static student[] student;
	private int currentIndex;

	public addStudent() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setVisible(true);
		setTitle("Student Data Form");
		setResizable(false);
		setSize(847, 509);
		header = new JLabel("Student Data Form", JLabel.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblname = new JLabel("Name: ");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		txtName = new JTextField(10);
		lblmatric = new JLabel("Matric Number: ");
		lblmatric.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmatric.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatric = new JTextField(10);
		yOfStudy = new JLabel("Year of Study: ");
		yOfStudy.setFont(new Font("Tahoma", Font.BOLD, 11));
		y1 = new JRadioButton("Year 1");
		y2 = new JRadioButton("Year 2");
		y3 = new JRadioButton("Year 3");
		y4 = new JRadioButton("Year 4");
		insertData = new JButton("Insert Data");
		insertData.setFont(new Font("Tahoma", Font.BOLD, 12));
		viewData = new JButton("View Data");
		viewData.setFont(new Font("Tahoma", Font.BOLD, 12));
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		student = new student[30];
		currentIndex = 0;
		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(lblname);
		p1.add(txtName);

		p1.add(lblmatric);
		p1.add(txtMatric);
		JPanel p2 = new JPanel(new GridLayout(2, 2));
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < years.length; i++) {
			years[i] = new JRadioButton("Year" + (i + 1));
			group.add(years[i]);
			p2.add(years[i]);
		}
		JPanel p3 = new JPanel(new FlowLayout());
		p3.add(yOfStudy);
		p3.add(p2);
		JPanel p13 = new JPanel(new GridLayout(2, 1));
		p13.add(p1);
		p13.add(p3);
		JPanel p4 = new JPanel(new FlowLayout());
		insertData.addActionListener(this);
		viewData.addActionListener(this);
		p4.add(insertData);
		p4.add(viewData);
		pane.add(p13, BorderLayout.WEST);
		pane.add(header, BorderLayout.NORTH);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(p4, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == insertData) {
			String name = txtName.getText();
			String matric = txtMatric.getText();
			int year = 0;
			for (int i = 0; i < years.length; i++) {

				if (years[i].getSelectedObjects() != null) {
					year = i + 1;
				}

			}
			student newStudent = new student(name, matric, year);
			student[currentIndex] = newStudent;
			currentIndex++;
			txtName.setText("");
			txtMatric.setText("");
		}
		if (obj == viewData) {
			for (int i = 0; i < student.length; i++) {
				if (i == 0) {
					textArea.append("The list of students :");
				}
				if (student[i] != null) {
					textArea.append("\n\nName: " + student[i].getName() + "\nMatric Number: " + student[i].getMatric()
							+ "\nYear Of Study: " + student[i].getYear());
				}
			}
		}
	}

	public static student[] getStudentArray() {
		return student;
	}
}

