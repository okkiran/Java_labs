import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StringFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstString; // first text field
	private JTextField txtSecondString; // second text field
	private JTextField txtBegin; // beginning index text field
	private JTextField txtEnd; // end index text field
	
	String newString; // new string that string operations are made through the text fields by clicking the buttons

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringFrame frame = new StringFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// member method that clears all of the text fields of the frame
	public void clean() {
		txtFirstString.setText("");
		txtSecondString.setText("");
		txtBegin.setText("0");
		txtEnd.setText("0");
	}
	
	/**
	 * Create the frame.
	 */
	public StringFrame() {
		setTitle("String Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("First String:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(107, 24, 92, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Second String:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(107, 53, 92, 13);
		contentPane.add(lblNewLabel_1);

		txtFirstString = new JTextField();
		txtFirstString.setBounds(209, 22, 300, 19);
		contentPane.add(txtFirstString);
		txtFirstString.setColumns(10);

		txtSecondString = new JTextField();
		txtSecondString.setBounds(209, 51, 300, 19);
		contentPane.add(txtSecondString);
		txtSecondString.setColumns(10);

		JButton btnConcatenate = new JButton("Concatenate");
		btnConcatenate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConcatenate.setBounds(135, 132, 115, 21);
		contentPane.add(btnConcatenate);

		JButton btnFindLength = new JButton("Find Length");
		btnFindLength.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFindLength.setBounds(260, 132, 115, 21);
		contentPane.add(btnFindLength);

		JButton btnReplace = new JButton("Replace");
		btnReplace.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnReplace.setBounds(385, 132, 115, 21);
		contentPane.add(btnReplace);

		JButton btnReplaceWord = new JButton("Replace Word");
		btnReplaceWord.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnReplaceWord.setBounds(510, 132, 115, 21);
		contentPane.add(btnReplaceWord);

		JLabel lblNewLabel_2 = new JLabel("Begin Index:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(20, 179, 75, 13);
		contentPane.add(lblNewLabel_2);

		txtBegin = new JTextField();
		txtBegin.setText("0");
		txtBegin.setBounds(93, 175, 20, 19);
		contentPane.add(txtBegin);
		txtBegin.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("End Index:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(20, 203, 75, 13);
		contentPane.add(lblNewLabel_3);

		txtEnd = new JTextField();
		txtEnd.setText("0");
		txtEnd.setBounds(93, 199, 20, 19);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		JButton btnSubstring = new JButton("Substring");
		btnSubstring.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSubstring.setBounds(135, 174, 115, 21);
		contentPane.add(btnSubstring);

		JButton btnUpperCase = new JButton("Upper Case");
		btnUpperCase.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpperCase.setBounds(260, 174, 115, 21);
		contentPane.add(btnUpperCase);

		JButton btnLowerCase = new JButton("Lower Case");
		btnLowerCase.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLowerCase.setBounds(385, 174, 115, 21);
		contentPane.add(btnLowerCase);

		JTextArea taResult = new JTextArea();
		taResult.setBounds(10, 238, 615, 89);
		contentPane.add(taResult);
		
		JLabel lblNewLabel_1_1 = new JLabel("New String:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(107, 94, 92, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnTrim = new JButton("Trim");
		btnTrim.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTrim.setBounds(510, 175, 115, 21);
		contentPane.add(btnTrim);
		
		JLabel lblNewString = new JLabel("");
		lblNewString.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewString.setBounds(209, 94, 300, 13);
		contentPane.add(lblNewString);
		
		JButton btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnClean.setBounds(10, 131, 115, 21);
		contentPane.add(btnClean);
		
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // clean button click event
				clean(); // invoking the clean member method to clear all the text fields
			}
		});
		
		btnConcatenate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // concatenate button click event
				// concat method concatenates the parameter (" " + secondString) to the variable (firstString) it is called from
				String firstString = txtFirstString.getText();
				String secondString = txtSecondString.getText();
				newString = firstString.concat(" " + secondString);
				taResult.setText("New String -> " + newString);
				lblNewString.setText(newString);
			}
		});
		
		btnFindLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // find length button click event
				// length method returns the character count of a string,
				// since string is an array of characters, character count is the length of the array
				clean(); // invoking clean method the clear the text fields
				taResult.setText("Length of the New String -> " + newString.length());
			}
		});
		
		btnReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // replace button click event
				// replace method replaces the first parameter (char) with the second parameter (char) of a string
				char firstChar = txtFirstString.getText().charAt(0);
				char secondChar = txtSecondString.getText().charAt(0);
				newString = newString.replace(firstChar, secondChar);
				taResult.setText("Replaced!\nNew String -> " + newString);
			}
		});
		
		btnReplaceWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // replace word click event
				// replace method replaces the first parameter (string) with the second parameter (string) of a string
				newString = newString.replace(txtFirstString.getText(), txtSecondString.getText());
				taResult.setText("Replaced!\nNew String -> " + newString);
			}
		});
		
		btnSubstring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // substring button click event
				// substring method returns the part of a string between the beginning and end indices
				int beginIndex = Integer.parseInt(txtBegin.getText());
				int endIndex = Integer.parseInt(txtEnd.getText());
				String subString = newString.substring(beginIndex, endIndex);
				taResult.setText("Characters between the range -> " + subString);
			}
		});
		
		btnUpperCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // upper case button click event
				// toUpperCase method converts all the characters of a string to upper case 
				clean(); // invoking clean method the clear the text fields
				newString = newString.toUpperCase();
				taResult.setText("Converted to Upper Case letters!\nNew String is -> " + newString);
			}
		});
		
		btnLowerCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // lower case button click event
				// toLowerCase method converts all the characters of a string to lower case 
				clean(); // invoking clean method the clear the text fields
				newString = newString.toLowerCase();
				taResult.setText("Converted to Lower Case letters!\nNew String is -> " + newString);
			}
		});
		
		btnTrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // trim button click event
				// trim method removes all the white space characters from the beginning and end of a string
				String firstString = txtFirstString.getText();
				taResult.setText("Trimmed!\nFirst String -> \"" + firstString.trim() + "\"");
			}
		});
	}

}
