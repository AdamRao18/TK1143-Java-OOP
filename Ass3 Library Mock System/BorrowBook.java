import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorrowBook extends JFrame implements ActionListener {
	private JLabel lblstd, lblbk, lblinfo, lblresult;
	private Student [] Sdata;
	private Book [] Bdata;
	private JComboBox <Student> std;
	private JComboBox <Book> bk;
	private JButton borrow;
	
	public BorrowBook() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		setTitle("Borrow Book");
		setVisible(true);
		setSize(500,250);
		
		Sdata = AddStudent.getArrayStudent(); 
		Bdata = AddBook.getArrayBook();
		
		// Create components
		lblstd = new JLabel("Student Name & Matric:");
		lblbk = new JLabel("Book Title & Author:");
		std = new JComboBox <> (Sdata);
		bk = new JComboBox <> (Bdata);
		borrow = new JButton ("Borrow"); 
		lblinfo = new JLabel ("Borrow Information : ");
		lblresult = new JLabel();
		
		borrow.addActionListener(this);
		std.addActionListener(this);
		bk.addActionListener(this);
		
		// Add components to the frame
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(lblstd);
        inputPanel.add(std);
        inputPanel.add(lblbk);
        inputPanel.add(bk);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(borrow);

        JPanel infoPanel = new JPanel(new GridLayout(2,1));
        infoPanel.add(lblinfo);
        infoPanel.add(lblresult);
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Student s;
		Book b;
		
		int indexS = std.getSelectedIndex();
		int indexB = bk.getSelectedIndex();
		
		s = Sdata[indexS];
		b = Bdata[indexB];
				
		b.borrowBy(s);
		
		if(obj==borrow)
			lblresult.setText(s.getName() + " with matric number " + s.getMatric() + " has borrow a book with title " + b.getTitle() + ".");		
	}
}
