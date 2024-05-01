
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainMenu extends JFrame implements ActionListener {
	private JButton addStud, addCrs, addReg;
	private JLabel title;
	
	public mainMenu() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		title = new JLabel (" ~~ Course Registration System ~~ ", JLabel.CENTER);
		addStud = new JButton("Add Student Data");
		addCrs = new JButton("Add Course Data");
		addReg = new JButton("Register Course");
		
		JPanel p1 = new JPanel(new GridLayout (4,10,1,10));
		p1.add(title);
		p1.add(addStud);
		p1.add(addCrs);
		p1.add(addReg);
		
		//register event 
		addStud.addActionListener(this);
		addCrs.addActionListener(this);
		addReg.addActionListener(this);
		
		pane.add(p1, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==addStud) {
			new addStudent();
		}
		if(obj==addCrs) {
			new AddCourse();
		}
		if(obj==addReg){
			new registration();
		}
		
	}
	
	public static void main(String[] args) {
		mainMenu menu = new mainMenu();
		menu.setTitle("Main Menu");
		menu.setResizable(false);
		menu.setVisible(true);
		menu.setSize(300,250);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
