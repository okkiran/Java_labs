import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox labNameCMB;
	private JTextArea dispTA;

	// method for returning the search frame's combo box
	public JComboBox getLabName_CMB() {
        return labNameCMB;
    }

	/**
	 * Create the frame.
	 */
	public SearchFrame() {
		setTitle("Search Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel();
		lblName.setText("Lab Name:");
		lblName.setBounds(10, 15, 68, 14);
		contentPane.add(lblName);
		
		labNameCMB = new JComboBox();
		labNameCMB.setBounds(82, 11, 105, 22);
		contentPane.add(labNameCMB);
		
		dispTA = new JTextArea();
		dispTA.setRows(5);
		dispTA.setColumns(20);
		dispTA.setBounds(10, 46, 349, 155);
		contentPane.add(dispTA);
		
		JButton btnSearch = new JButton();
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LaboratorySys.getArr().isEmpty()) {
		            dispTA.setText("Array List is empty");
		        } else {
		            dispTA.setText(LaboratorySys.searchLaboratory(((String)labNameCMB.getSelectedItem())).toString());
		        }
			}
		});
		btnSearch.setText("Search");
		btnSearch.setBounds(197, 11, 82, 23);
		contentPane.add(btnSearch);
		
		JButton btnClose = new JButton();
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispTA.setText(null);
		        labNameCMB.setSelectedIndex(0);
		        dispose();
			}
		});
		btnClose.setText("Close");
		btnClose.setBounds(289, 11, 70, 23);
		contentPane.add(btnClose);
	}

}
