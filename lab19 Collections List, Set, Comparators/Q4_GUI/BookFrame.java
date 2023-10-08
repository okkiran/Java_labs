package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystemClass.BookSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField isbnTF;
	private JTextField authorNameTF;
	private JTextField categoryTF;
	private JTextField titleTF;
	private JTextField yearTF;
	private JTextField formatTF;
	
	SearchFrame sf = new SearchFrame(this);
	private JTextArea dispTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookFrame frame = new BookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookFrame() {
		setTitle("Book Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel isbnLabel = new JLabel();
		isbnLabel.setText("ISBN:");
		isbnLabel.setBounds(20, 11, 61, 14);
		contentPane.add(isbnLabel);
		
		JLabel authorNameLabel = new JLabel();
		authorNameLabel.setText("Autor Name:");
		authorNameLabel.setBounds(20, 46, 79, 14);
		contentPane.add(authorNameLabel);
		
		JLabel categoryLabel = new JLabel();
		categoryLabel.setText("Category:");
		categoryLabel.setBounds(20, 87, 79, 14);
		contentPane.add(categoryLabel);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Title:");
		titleLabel.setBounds(20, 134, 51, 14);
		contentPane.add(titleLabel);
		
		JLabel yearLabel = new JLabel();
		yearLabel.setText("Year:");
		yearLabel.setBounds(20, 173, 49, 14);
		contentPane.add(yearLabel);
		
		JLabel formatLabel = new JLabel();
		formatLabel.setText("Format:");
		formatLabel.setBounds(20, 217, 61, 14);
		contentPane.add(formatLabel);
		
		isbnTF = new JTextField();
		isbnTF.setBounds(109, 8, 242, 20);
		contentPane.add(isbnTF);
		
		authorNameTF = new JTextField();
		authorNameTF.setBounds(109, 43, 242, 20);
		contentPane.add(authorNameTF);
		
		categoryTF = new JTextField();
		categoryTF.setBounds(109, 84, 242, 20);
		contentPane.add(categoryTF);
		
		titleTF = new JTextField();
		titleTF.setBounds(109, 131, 242, 20);
		contentPane.add(titleTF);
		
		yearTF = new JTextField();
		yearTF.setBounds(109, 170, 242, 20);
		contentPane.add(yearTF);
		
		formatTF = new JTextField();
		formatTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            if (isbnTF.getText().equals("") || authorNameTF.getText().equals("")
		                    || categoryTF.getText().equals("") || titleTF.getText().equals("")
		                    || formatTF.getText().equals("")) {

		                dispTA.setText("Fill the necessary fields");
		            } else {

		                boolean res = BookSys.addToBookSet(Integer.parseInt(isbnTF.getText()), authorNameTF.getText(),
		                        categoryTF.getText(), titleTF.getText(), Integer.parseInt(yearTF.getText()), formatTF.getText());
		                if (res) {
		                    dispTA.setText("Book is added");
		                } else {
		                    dispTA.setText("A book with the same isbn already exists in the system");
		                }

		            }

		            sf.getISBNCMB().setModel(new DefaultComboBoxModel(BookSys.getIsbn()));
		        }
				
			}
		});
		formatTF.setBounds(109, 214, 242, 20);
		contentPane.add(formatTF);
		
		JButton AddButton = new JButton();
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isbnTF.getText().equals("") || authorNameTF.getText().equals("")
		                || categoryTF.getText().equals("") || titleTF.getText().equals("")
		                || formatTF.getText().equals("")) {

		            dispTA.setText("Fill the necessary fields");
		        } else {

		            boolean res = BookSys.addToBookSet(Integer.parseInt(isbnTF.getText()), authorNameTF.getText(),
		                    categoryTF.getText(), titleTF.getText(), Integer.parseInt(yearTF.getText()), formatTF.getText());
		            if (res) {
		                dispTA.setText("Book is added");
		            } else {
		                dispTA.setText("A book with the same isbn already exists in the system");
		            }

		        }
				sf.getISBNCMB().setModel(new DefaultComboBoxModel(BookSys.getIsbn()));
			}
		});
		AddButton.setText("ADD");
		AddButton.setBounds(39, 266, 126, 23);
		contentPane.add(AddButton);
		
		JButton displayButton = new JButton();
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BookSys.getBook().isEmpty()) {
		            dispTA.setText("Set is empty");
		        } else {
		            dispTA.setText(BookSys.displayAll());
		        }
			}
		});
		displayButton.setText("DISPLAY");
		displayButton.setBounds(183, 266, 149, 23);
		contentPane.add(displayButton);
		
		JButton clearButton = new JButton();
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 isbnTF.setText("");
			     authorNameTF.setText("");
			     categoryTF.setText("");
			     titleTF.setText("");
			     yearTF.setText("");
			     formatTF.setText("");
			     dispTA.setText("");
			}
		});
		clearButton.setText("CLEAR");
		clearButton.setBounds(39, 307, 126, 23);
		contentPane.add(clearButton);
		
		JButton searchButton = new JButton();
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (BookSys.getBook().isEmpty()) {
			            dispTA.setText("Set is empty");
			        } else {
			            sf.setVisible(true);
			            sf.setDispTA(BookSys.search(Integer.parseInt(BookSys.getIsbn()[0])).toString());
			            sf.getISBNCMB().setModel(new DefaultComboBoxModel(BookSys.getIsbn()));
			           
			        }
			}
		});
		searchButton.setText("SEARCH");
		searchButton.setBounds(183, 307, 149, 23);
		contentPane.add(searchButton);
		
		JButton dispByCategryBTN = new JButton();
		dispByCategryBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (BookSys.getBook().isEmpty()) {
			            dispTA.setText("Set is empty");
			        } else {
			            dispTA.setText(BookSys.displayBooksByCategory());
			        }
			}
		});
		dispByCategryBTN.setText("DISPLAY BY CATEGORY");
		dispByCategryBTN.setBounds(73, 341, 225, 23);
		contentPane.add(dispByCategryBTN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(361, 11, 394, 360);
		contentPane.add(scrollPane);
		
		dispTA = new JTextArea();
		scrollPane.setViewportView(dispTA);
	}

}
