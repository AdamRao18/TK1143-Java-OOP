
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.Window.Type;

public class AddCourse extends JFrame implements ActionListener {
	private JLabel header, lblCode, lblName, lblMax;
	private JButton insertCourse, viewCourse;
	private JTextField txtCode, txtName, txtMax;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	static course[] course;
	private int currentIndex;

	public AddCourse() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Arial Black", Font.BOLD, 12));
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		setVisible(true);
		setTitle("Course Data Form");
		setResizable(false);
		setSize(849,509);
		
		header = new JLabel("Course Data Form", JLabel.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCode = new JLabel("Course Code: ");
		lblCode.setForeground(Color.BLACK);
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCode.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		txtCode = new JTextField(10);
		lblName = new JLabel("Course Name: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtName = new JTextField(10);
		lblMax = new JLabel("Maximum \r\nStudent:");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMax = new JTextField(10);
		
		insertCourse = new JButton("Insert Course");
		insertCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewCourse = new JButton("View Course");
		viewCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		currentIndex = 0;
		course = new course[5];
		
		JPanel p1 = new JPanel(new GridLayout(3,2));
		p1.add(lblCode);
		p1.add(txtCode);
		p1.add(lblName);
		p1.add(txtName);
		p1.add(lblMax);
		p1.add(txtMax);

		JPanel p4 = new JPanel(new FlowLayout());
		insertCourse.addActionListener(this);
		viewCourse.addActionListener(this);
		
		p4.add(insertCourse);
		p4.add(viewCourse);
		
		pane.add(p1,BorderLayout.WEST);
		pane.add(header,BorderLayout.NORTH);
		pane.add(scrollPane,BorderLayout.CENTER);
		pane.add(p4,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String code = txtCode.getText();
		String cName = txtName.getText();
		String max = txtMax.getText();

		if (obj == insertCourse) {
			course newcourse = new course(code, cName, max);
			course[currentIndex] = newcourse;
			currentIndex++;
			txtCode.setText("");
			txtName.setText("");
			txtMax.setText("");
		}
		if (obj == viewCourse) {
			for (int i = 0; i < course.length; i++) {
				if (i == 0) {
					textArea.append("The list of courses :");
				}
				if (course[i] != null) {
					textArea.append("\n\nCourse Code : " + course[i].getCode() + "\nCourse Name : "+ course[i].getName() + "\nMaximum Student: " + course[i].getMax());
				}
			}
		}
	}

	public static course[] getCourseArray() {
		return course;
	}
}