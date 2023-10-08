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
	private JTextField txtLabName;
	private JTextField txtSize;
	private JTextField txtYear;
	private JTextField txtMaintainer;
	private JLabel lblMsg;
	
	// method for clearing the text fields
	public void clear() {
		txtLabName.setText(null);
		txtSize.setText(null);
		txtYear.setText(null);
		txtMaintainer.setText(null);
    }

	/**
	 * Create the frame.
	 */
	public AddFrame(LaboratoryFrame laboratoryFrame) {
		setTitle("Add Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel();
		lblName.setText("Lab Name:");
		lblName.setBounds(10, 14, 100, 14);
		contentPane.add(lblName);
		
		JLabel lblSize = new JLabel();
		lblSize.setText("Size:");
		lblSize.setBounds(10, 45, 100, 14);
		contentPane.add(lblSize);
		
		JLabel lblYear = new JLabel();
		lblYear.setText("Renew Year:");
		lblYear.setBounds(10, 73, 100, 14);
		contentPane.add(lblYear);
		
		JLabel lblMaintainer = new JLabel();
		lblMaintainer.setText("Lab Maintainer:");
		lblMaintainer.setBounds(10, 104, 100, 14);
		contentPane.add(lblMaintainer);
		
		txtLabName = new JTextField();
		txtLabName.setBounds(131, 11, 150, 20);
		contentPane.add(txtLabName);
		
		txtSize = new JTextField();
		txtSize.setBounds(131, 42, 150, 20);
		contentPane.add(txtSize);
		
		txtYear = new JTextField();
		txtYear.setBounds(131, 70, 150, 20);
		contentPane.add(txtYear);
		
		txtMaintainer = new JTextField();
		txtMaintainer.setBounds(131, 101, 150, 20);
		contentPane.add(txtMaintainer);
		
		JButton btnAdd = new JButton();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtLabName.getText().isEmpty() || txtSize.getText().isEmpty() || txtYear.getText().isEmpty() || txtMaintainer.getText().isEmpty()) {
			            lblMsg.setText("Please fill all of the fields");
		        } else {
		            String labName, labMaintainer;
		            int size, renewYear;
		            labName = txtLabName.getText();
		            size = Integer.parseInt(txtSize.getText());
		            renewYear = Integer.parseInt(txtYear.getText());
		            labMaintainer = txtMaintainer.getText();
		            Laboratory laboratory = new Laboratory(labName, size, renewYear, labMaintainer);
		            boolean result = LaboratorySys.addLaboratory(laboratory);
		            if (result) {
		                lblMsg.setText("The laboratory added to the system");
		                laboratoryFrame.fillComboBox();
		            } else {
		                lblMsg.setText("The laboratory already exists in the system");
		            }
	            	clear();
		        }
			}
		});
		btnAdd.setText("Add");
		btnAdd.setBounds(38, 164, 85, 23);
		contentPane.add(btnAdd);
		
		JButton btnClose = new JButton();
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setText("Close");
		btnClose.setBounds(162, 164, 80, 23);
		contentPane.add(btnClose);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 139, 314, 14);
		contentPane.add(lblMsg);
	}

}
