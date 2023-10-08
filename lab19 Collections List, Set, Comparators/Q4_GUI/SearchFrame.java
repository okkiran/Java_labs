package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookInheritance.Book;
import MainandSystemClass.BookSys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	BookFrame bf = null;
	private JComboBox<String> isbnCMB;
	private JTextArea dispTA;
	private JButton closeButton;
	
	 public JComboBox<String> getISBNCMB() {
	     return isbnCMB;
	 }

	 public void setDispTA(String res) {
	    dispTA.setText(res);
	 }

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame1 frame = new SearchFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SearchFrame(BookFrame frame) {
		bf = frame;
		setTitle("SearchFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel isbnLabel = new JLabel();
		isbnLabel.setText("ISBN:");
		isbnLabel.setBounds(24, 15, 48, 14);
		contentPane.add(isbnLabel);
		
		isbnCMB = new JComboBox<String>();
		isbnCMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int isbn = Integer.parseInt((String) isbnCMB.getSelectedItem());
			        Book b = BookSys.search(isbn);
			        dispTA.setText(b.toString());
			}
		});
		isbnCMB.setBounds(82, 11, 99, 22);
		contentPane.add(isbnCMB);
		
		dispTA = new JTextArea();
		dispTA.setRows(5);
		dispTA.setColumns(20);
		dispTA.setBounds(25, 52, 367, 222);
		contentPane.add(dispTA);
		
		closeButton = new JButton();
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bf.setVisible(true);
		        dispose();
			}
		});
		closeButton.setText("CLOSE");
		closeButton.setBounds(167, 286, 89, 23);
		contentPane.add(closeButton);
	}
}
