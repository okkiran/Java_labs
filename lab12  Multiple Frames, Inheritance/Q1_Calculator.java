import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private JPanel contentPane;
	
	// frame variable declarations and initializations:
	// this references to the current created and used Calculator object.
	Summation summationFrame = new Summation(this); 
	Subtraction subtractionFrame = new Subtraction(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Operation:");
		lblNewLabel.setBounds(85, 33, 100, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSummation = new JButton("+");
		
		btnSummation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				summationFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		btnSummation.setBounds(85, 58, 50, 23);
		contentPane.add(btnSummation);
		
		JButton btnSubtraction = new JButton("-");
		
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				subtractionFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		btnSubtraction.setBounds(145, 58, 50, 23);
		contentPane.add(btnSubtraction);
	}
}
