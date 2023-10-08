import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HospitalMemberFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea resultTxtArea;
	
	// initializing an object of type AddFrame and sending HospitalMemberFrame object as a parameter to its constructor
	AddFrame addFrame = new AddFrame(this);
	
	// for showing the message sent from the AddFrame frame 
	public void setMessage(String message) {
		resultTxtArea.setText(message);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalMemberFrame frame = new HospitalMemberFrame();
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
	public HospitalMemberFrame() {
		setTitle("Hospital Member Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton displayBtn = new JButton("Display");
		displayBtn.setBounds(31, 31, 111, 21);
		contentPane.add(displayBtn);
		
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(299, 31, 111, 21);
		contentPane.add(addBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 78, 379, 175);
		contentPane.add(scrollPane);
		
		resultTxtArea = new JTextArea();
		scrollPane.setViewportView(resultTxtArea);
		
		displayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				if (HospitalMemberSys.getHm().isEmpty()) {
					resultTxtArea.setText("The array list is empty. Please fill first.");
				} else {
					resultTxtArea.setText(HospitalMemberSys.display());
				}
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				addFrame.setVisible(true);
				dispose();
			}
		});
		
	}

}
