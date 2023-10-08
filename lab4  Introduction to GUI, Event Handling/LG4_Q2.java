import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LG4_Q2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JRadioButton rdbtnAllowed;
	private JRadioButton rdbtnNotAllowed;
	private JTextArea textArea;
	ButtonGroup bt = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LG4_Q2 frame = new LG4_Q2();
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
	public LG4_Q2() {
		setTitle("LG4 - Q2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 477, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(40, 34, 46, 14);
		panel.add(lblName);
		
		JLabel lblSurname = new JLabel("SURNAME:");
		lblSurname.setBounds(40, 59, 80, 14);
		panel.add(lblSurname);
		
		txtName = new JTextField();
		txtName.setBounds(158, 31, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(158, 56, 86, 20);
		panel.add(txtSurname);
		txtSurname.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		
		// Submit button action listener
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Submit button action performed (click) event
				
				// declaration and assignment of the output variable that will be set to the textArea
				String output = "STUDENT INFORMATION\n";
		        output += "****************************\n";
		        output += txtName.getText() + " " + txtSurname.getText() + " ";
		        
		        if(rdbtnAllowed.isSelected()) // if allowed check box is checked          
		            output += "is ALLOWED :)";
		        else if(rdbtnNotAllowed.isSelected()) // if allowed check box is not checked
		            output += "is NOT ALLOWED!";

		        textArea.setText(output); // setting output variable's value to the textArea
			}
		});
		
		btnSubmit.setBounds(268, 30, 89, 23);
		panel.add(btnSubmit);
		
		JLabel lblStatus = new JLabel("Campus Access Status:");
		lblStatus.setBounds(40, 106, 172, 14);
		panel.add(lblStatus);
		
		rdbtnAllowed = new JRadioButton("Allowed");
		rdbtnAllowed.setSelected(true);
		bt.add(rdbtnAllowed);
		rdbtnAllowed.setBounds(222, 102, 109, 23);
		panel.add(rdbtnAllowed);
		
		rdbtnNotAllowed = new JRadioButton("Not Allowed");
		bt.add(rdbtnNotAllowed);
		rdbtnNotAllowed.setBounds(334, 102, 109, 23);
		panel.add(rdbtnNotAllowed);
		
		textArea = new JTextArea();
		textArea.setBounds(40, 159, 408, 137);
		panel.add(textArea);
	}

}
