import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalculatorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtDenum;
	private JTextArea txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorFrame frame = new CalculatorFrame();
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
	public CalculatorFrame() {
		setTitle("Calculate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumerator = new JLabel("Enter Numerator:");
		lblNumerator.setBounds(37, 22, 103, 14);
		contentPane.add(lblNumerator);
		
		JLabel lblDenom = new JLabel("Enter Denominator:");
		lblDenom.setBounds(37, 58, 120, 14);
		contentPane.add(lblDenom);
		
		txtNum = new JTextField();
		txtNum.setBounds(167, 19, 132, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtDenum = new JTextField();
		txtDenum.setBounds(167, 55, 132, 20);
		contentPane.add(txtDenum);
		txtDenum.setColumns(10);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(37, 97, 70, 14);
		contentPane.add(lblResult);
		
		JButton btnCalculate = new JButton("CALCULATE");
		
		btnCalculate.addActionListener(new ActionListener() { // calculate button click event
			public void actionPerformed(ActionEvent e) {
				 String result = Calculator.calculate(txtNum.getText(), txtDenum.getText());
			     txtResult.setText(result);
			}
		});
		
		btnCalculate.setBounds(37, 132, 103, 23);
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("CLEAR");
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // clear button click event
				txtNum.setText("");
				txtDenum.setText("");
				txtResult.setText("");
			}
		});
		
		btnClear.setBounds(37, 179, 103, 23);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 97, 273, 153);
		contentPane.add(scrollPane);
		
		txtResult = new JTextArea();
		scrollPane.setViewportView(txtResult);
	}

}
