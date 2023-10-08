import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class LaboratoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea displayTA;
	
	// text file name
	private final String fileName = "labs.txt";
	
	// frames
	AddFrame addFrame = new AddFrame(this);
	SearchFrame searchFrame = new SearchFrame(); 
	
	// method for filling the combo box of the search frame
	public void fillComboBox() {
        searchFrame.getLabName_CMB().setModel(new DefaultComboBoxModel(LaboratorySys.getLabNames()));
    }
	
	/**
	 * Create the frame.
	 */
	public LaboratoryFrame() {
		setTitle("Laboratory Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel();
		lblInfo.setText("Laboratory Info:");
		lblInfo.setBounds(23, 11, 117, 14);
		contentPane.add(lblInfo);
		
		JButton btnRead = new JButton();
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LaboratorySys.readTxt(fileName);
		        displayTA.setText("File is read");
			}
		});
		btnRead.setText("Read File");
		btnRead.setBounds(312, 77, 112, 23);
		contentPane.add(btnRead);
		
		JButton btnAdd = new JButton();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 addFrame.setVisible(true);
			}
		});
		btnAdd.setText("Add");
		btnAdd.setBounds(312, 125, 112, 23);
		contentPane.add(btnAdd);
		
		JButton btnSrch = new JButton();
		btnSrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillComboBox();
		        searchFrame.setVisible(true);
			}
		});
		btnSrch.setText("Search");
		btnSrch.setBounds(312, 159, 112, 23);
		contentPane.add(btnSrch);
		
		JButton btnDisplay = new JButton();
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LaboratorySys.getArr().isEmpty()) {
		            displayTA.setText("Array List is empty");
		        } else {
		            displayTA.setText(LaboratorySys.display());
		        }
			}
		});
		btnDisplay.setText("Display");
		btnDisplay.setBounds(312, 200, 112, 23);
		contentPane.add(btnDisplay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 53, 282, 255);
		contentPane.add(scrollPane);
		
		displayTA = new JTextArea();
		scrollPane.setViewportView(displayTA);
	}

}
