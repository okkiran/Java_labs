import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LG4_Q1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LG4_Q1 frame = new LG4_Q1();
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
	public LG4_Q1() {
		setTitle("LG 4 - Q1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrev = new JButton("Previous");
		
		// Previous button action listener
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Previous button action performed (click) event
				txtInfo.setText("PREVIOUS Button is clicked!"); // "PREVIOUS Button is clicked!" will be set to txtInfo text field 
			}
		});
		
		btnPrev.setBounds(111, 43, 89, 23);
		contentPane.add(btnPrev);
		
		JButton btnNext = new JButton("Next");
		
		// Next button action listener
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Next button action performed (click) event
				txtInfo.setText("NEXT Button is clicked!"); // "NEXT Button is clicked!" will be set to txtInfo text field
			}
		});
		
		btnNext.setBounds(210, 43, 89, 23);
		contentPane.add(btnNext);
		
		JLabel lblInfo = new JLabel("INFO:");
		lblInfo.setBounds(86, 106, 46, 14);
		contentPane.add(lblInfo);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(160, 103, 198, 20);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
	}

}
