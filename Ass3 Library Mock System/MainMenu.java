import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {
	//declare a component
	private JButton addS, addB, borrow;
	private JLabel title;
	
	public MainMenu() {
		//create a container and layout setting
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//create component
		title = new JLabel (" ~~ BORROW BOOK SYSTEM ~~ ", JLabel.CENTER);
		addS = new JButton("Add Student Info");
		addB = new JButton("Add Book Info");
		borrow = new JButton("Borrow Book");
		
		//create a panel and add component to the panel
		JPanel p1 = new JPanel(new GridLayout (4,10,1,10));
		p1.add(title);
		p1.add(addS);
		p1.add(addB);
		p1.add(borrow);
		
		//register event 
		addS.addActionListener(this);
		addB.addActionListener(this);
		borrow.addActionListener(this);
		
		//add panel to container
		pane.add(p1, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		//An event object contains a reference to the component that generated the event
		Object obj = e.getSource();
		
		//event based on the button
		if(obj==addS) {
			new AddStudent();
		}
		if(obj==addB) {
			new AddBook();
		}
		if(obj==borrow){
			new BorrowBook();
		}
		
	}
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.setTitle("Main Menu");
		menu.setResizable(false);
		menu.setVisible(true);
		menu.setSize(300,250);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
