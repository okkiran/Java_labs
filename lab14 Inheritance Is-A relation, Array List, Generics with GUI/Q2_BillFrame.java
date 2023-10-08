import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class BillFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfBillNumber;
	private JTextField tfNameSurname;
	private JTextField tfKwh;
	private JTextField tfM3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillFrame frame = new BillFrame();
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
	public BillFrame() {
		setTitle("Bill Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill Number:");
		lblNewLabel.setBounds(33, 30, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNameSurname = new JLabel("Name Surname:");
		lblNameSurname.setBounds(33, 67, 95, 14);
		contentPane.add(lblNameSurname);
		
		JLabel lblType = new JLabel("Electricity Bill");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(33, 120, 95, 14);
		contentPane.add(lblType);
		
		JPanel pnlElectricity = new JPanel();
		pnlElectricity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlElectricity.setBounds(33, 140, 240, 87);
		contentPane.add(pnlElectricity);
		pnlElectricity.setLayout(null);
		
		JPanel pnlWater = new JPanel();
		pnlWater.setBounds(33, 140, 240, 87);
		contentPane.add(pnlWater);
		pnlWater.setLayout(null);
		pnlWater.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JRadioButton rbElectricity = new JRadioButton("Electricity Bill");
		buttonGroup.add(rbElectricity);
		rbElectricity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // electricity radio button change event
				lblType.setText("Electricity Bill");
				pnlElectricity.setVisible(true);
				pnlWater.setVisible(false);
			}
		});
		rbElectricity.setSelected(true);
		rbElectricity.setBounds(400, 26, 109, 23);
		contentPane.add(rbElectricity);
		
		JRadioButton rbWater = new JRadioButton("Water Bill");
		buttonGroup.add(rbWater);
		rbWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // water radio button change event
				lblType.setText("Water Bill");
				pnlElectricity.setVisible(false);
				pnlWater.setVisible(true);
			}
		});
		rbWater.setBounds(400, 63, 109, 23);
		contentPane.add(rbWater);
		
		tfBillNumber = new JTextField();
		tfBillNumber.setBounds(152, 27, 175, 20);
		contentPane.add(tfBillNumber);
		tfBillNumber.setColumns(10);
		
		tfNameSurname = new JTextField();
		tfNameSurname.setColumns(10);
		tfNameSurname.setBounds(152, 64, 175, 20);
		contentPane.add(tfNameSurname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 253, 616, 210);
		contentPane.add(scrollPane);
		
		JTextArea taOutput = new JTextArea();
		scrollPane.setViewportView(taOutput);
		
		JButton btnAdd = new JButton("Add Bill");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // add bill click event
				boolean result;
				if (rbElectricity.isSelected()) {
					result = BillSys.addBill("electricity", Integer.parseInt(tfBillNumber.getText().trim()), tfNameSurname.getText().trim(), Double.parseDouble(tfKwh.getText().trim()));
				} else {
					result = BillSys.addBill("water", Integer.parseInt(tfBillNumber.getText().trim()), tfNameSurname.getText().trim(), Double.parseDouble(tfM3.getText().trim()));
				}
				if (result) {
					taOutput.setText("Bill is added");
				} else {
					taOutput.setText("Bill is already exist in the arraylist");
				}
			}
		});
		btnAdd.setBounds(560, 47, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblUsedKwh = new JLabel("Used kwh:");
		lblUsedKwh.setBounds(10, 36, 69, 14);
		pnlElectricity.add(lblUsedKwh);
		
		tfKwh = new JTextField();
		tfKwh.setBounds(89, 33, 105, 20);
		pnlElectricity.add(tfKwh);
		tfKwh.setColumns(10);
		
		JButton btnSearch = new JButton("Search Bill");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // search bill button click event
				BillSys.calcBill();
				Bill bill = BillSys.searchBill(Integer.parseInt(tfBillNumber.getText().trim()));
				if (bill == null) {
					taOutput.setText("Bill is NOT exist in the arraylist");
				} else {
					taOutput.setText(bill.toString());
				}
			}
		});
		btnSearch.setBounds(350, 153, 117, 23);
		contentPane.add(btnSearch);
		
		JButton btnDisplay = new JButton("Display Bill");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // display bill button click event
				BillSys.calcBill();
				taOutput.setText(BillSys.display());
			}
		});
		btnDisplay.setBounds(532, 153, 117, 23);
		contentPane.add(btnDisplay);
		
		JLabel lblUsedM = new JLabel("Used m3:");
		lblUsedM.setBounds(10, 36, 69, 14);
		pnlWater.add(lblUsedM);
		
		tfM3 = new JTextField();
		tfM3.setColumns(10);
		tfM3.setBounds(89, 33, 105, 20);
		pnlWater.add(tfM3);
	}
}
