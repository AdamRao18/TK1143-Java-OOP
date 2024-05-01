import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddBook extends JFrame implements ActionListener{
	private JLabel lbltitle, lblauthor;
	private JTextField titleField, authorField;
	private JButton addBtn,listBtn;
	static Book [] books;
	private int currentIndex;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	public AddBook() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setTitle("Add Book Info");
		setVisible(true);
		setSize(500,250);

		// Create components
		lbltitle = new JLabel("Book Title:");
		lblauthor = new JLabel("Author:");
		titleField = new JTextField(20);
		authorField = new JTextField(20);
		addBtn = new JButton("Add");
		addBtn.addActionListener(this);
		listBtn = new JButton("List");
		listBtn.addActionListener(this);

		books = new Book[5];
		currentIndex = 0;

		// Add components to the panel
		JPanel inputPanel = new JPanel(new GridLayout(2, 2));
		inputPanel.add(lbltitle);
		inputPanel.add(titleField);
		inputPanel.add(lblauthor);
		inputPanel.add(authorField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addBtn);
		buttonPanel.add(listBtn);

		JPanel listPanel = new JPanel(new BorderLayout());
		listPanel.add(new JLabel("Books:"), BorderLayout.NORTH);
		textArea = new JTextArea(5,40);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listPanel.add(scrollPane);

		add(inputPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(listPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj==addBtn) {
			// Get the input values
			String title = titleField.getText();
			String author = authorField.getText();

			// Create a new student object
			Book newBook = new Book(title, author);

			// Add the student to the array
			books[currentIndex] = newBook;
			currentIndex++;

			// If the array is full, double its size
			if (currentIndex >= books.length) { 
				Book[] newBooks = new Book[books.length * 2]; System.arraycopy(books, 0, newBooks, 0, books.length); 
				books = newBooks;
			}

			// Clear the input fields
			titleField.setText("");
			authorField.setText("");
		}
		if(obj==listBtn) {
			for (Book book : books) {
				if (book != null) {
					textArea.append("Book title : " + book.getTitle() + " (Author : " + book.getAuthor() + ") \n" );
				}
			}
		}
	}

	public static Book [] getArrayBook() {
		return books;
	}
}
