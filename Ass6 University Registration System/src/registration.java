
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class registration extends JFrame implements ActionListener {
	private JLabel sData, cData, rInfo;
	private JButton register;
	private JTextArea textArea;
	private JComboBox std, data;
	private JScrollPane scrollPane;
	private student[] Sdata;
	private course[] Cdata;
	private int count;

	public registration() {
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3, 1));
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setVisible(true);
		setTitle("Register Course");
		setResizable(false);
		setSize(849, 509);
		Sdata = addStudent.getStudentArray();
		Cdata = AddCourse.getCourseArray();

		sData = new JLabel("Student Data: ");
		std = new JComboBox(Sdata);
		cData = new JLabel("Course Data: ");
		data = new JComboBox(Cdata);
		register = new JButton("Register");
		rInfo = new JLabel("Registration Information");
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		count = 0;
		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(sData);
		p1.add(std);
		p1.add(cData);
		p1.add(data);
		JPanel p2 = new JPanel(new GridLayout(2, 1));
		p2.add(rInfo);
		p2.add(scrollPane);
		register.addActionListener(this);
		JPanel p3 = new JPanel();
		p3.add(register);
		pane.add(p1);
		pane.add(p3);
		pane.add(p2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		student s;
		course c;
		int indexS = std.getSelectedIndex();
		int indexC = data.getSelectedIndex();
		s = Sdata[indexS];
		c = Cdata[indexC];
		if (obj == register) {
			c.enrolledBy(s);
			if (c.enrolledBy(s)== false) {
				textArea.append("\nSORRY!!" + c.getCode() + " course registration is full.");
			} else {
				textArea.append("\n" + s.getName() + " with matric number " + s.getMatric() + " successfully enroll in "
					+ c.getCode() + ".");

			}
		}
	}
}