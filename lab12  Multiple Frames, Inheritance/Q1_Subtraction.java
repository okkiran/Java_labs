import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Subtraction extends JFrame {

	private JPanel contentPane;
	private JTextField tfNo1;
	private JTextField tfNo2;
	private JButton btnBack;
	
	// frame variable declarations:
	Calculator calculator;

	/**
	 * Create the frame.
	 */
	public Subtraction(Calculator calculator) {
		
		// assigning the Calculator object sent as parameter to this frame's calculator reference variable.
		this.calculator = calculator;
		
		setTitle("Subtraction");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNo1 = new JTextField();
		tfNo1.setBounds(24, 34, 86, 20);
		contentPane.add(tfNo1);
		tfNo1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setBounds(120, 37, 20, 14);
		contentPane.add(lblNewLabel);
		
		tfNo2 = new JTextField();
		tfNo2.setColumns(10);
		tfNo2.setBounds(140, 34, 86, 20);
		contentPane.add(tfNo2);
		
		JLabel lblResult = new JLabel("");
		lblResult.setBounds(292, 11, 60, 43);
		contentPane.add(lblResult);
		
		lblResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		JButton btnEqual = new JButton("=");
		
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				int result = Integer.parseInt(tfNo1.getText()) - Integer.parseInt(tfNo2.getText());
				lblResult.setText("" + result);
			}
		});
		
		btnEqual.setBounds(236, 33, 46, 23);
		contentPane.add(btnEqual);
		
		btnBack = new JButton("<-");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // button click event
				calculator.setVisible(true);
				dispose();
			}
		});
		
		btnBack.setBounds(378, 33, 46, 23);
		contentPane.add(btnBack);
	}

}
