import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTxtField;
	private JTextField nameSurnameTxtField;
	private JTextField deptTxtField;

	// declaration of the hospitalMemberFrame variable to set in the constructor
	HospitalMemberFrame hospitalMemberFrame;

	// member method the clear the text fields
	public void clean() {
		nameSurnameTxtField.setText("");
		deptTxtField.setText("");
		idTxtField.setText("");
	}

	/**
	 * Create the frame.
	 */
	public AddFrame(HospitalMemberFrame hospitalMemberFrame) {
		
		this.hospitalMemberFrame = hospitalMemberFrame; // assigning the object parameter to the data member of the class
		
		setTitle("Add Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(72, 47, 82, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name Surname:");
		lblNewLabel_1.setBounds(72, 82, 100, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Dept:");
		lblNewLabel_2.setBounds(72, 116, 82, 13);
		contentPane.add(lblNewLabel_2);

		idTxtField = new JTextField();
		idTxtField.setBounds(178, 44, 197, 19);
		contentPane.add(idTxtField);
		idTxtField.setColumns(10);

		nameSurnameTxtField = new JTextField();
		nameSurnameTxtField.setBounds(178, 79, 197, 19);
		contentPane.add(nameSurnameTxtField);
		nameSurnameTxtField.setColumns(10);

		deptTxtField = new JTextField();
		deptTxtField.setBounds(178, 113, 197, 19);
		contentPane.add(deptTxtField);
		deptTxtField.setColumns(10);

		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(72, 162, 314, 39);
		contentPane.add(resultLabel);

		JButton addBtn = new JButton("Add");
		addBtn.setBounds(72, 211, 111, 21);
		contentPane.add(addBtn);

		JButton closeBtn = new JButton("Close");
		closeBtn.setBounds(264, 211, 111, 21);
		contentPane.add(closeBtn);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event

				// getting input values from the text fields
				int id = Integer.parseInt(idTxtField.getText());
				String name = nameSurnameTxtField.getText();
				String dept = deptTxtField.getText();

				// adding hospital member
				boolean result = HospitalMemberSys.addHospitalMember(id, name, dept);

				// displaying result
				if (result) {
					resultLabel.setText("Hospital Member is added!");
				} else {
					resultLabel.setText("Hospital Member could not added. It is already exist!");
				}
				
				// clearing the text fields
				clean();
			}
		});

		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event

				// displaying a message in the text area of the HospitalMemberFrame 
				// according to the array list elements' count
				if (HospitalMemberSys.getHm().isEmpty()) {
					hospitalMemberFrame.setMessage("No addition. Array List is empty.");
				} else {
					hospitalMemberFrame.setMessage(""); // clearing the text area
				}
				
				hospitalMemberFrame.setVisible(true);
				dispose();
			}
		});
		
	}

}
