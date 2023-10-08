import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MusicianFrame extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField tfNameSurname;
	private JTextField tfExperienceYear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicianFrame frame = new MusicianFrame();
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
	public MusicianFrame() {
		setTitle("Musician Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Musician Name Surname:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 11, 160, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Music Style:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 44, 160, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Experience Year:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 81, 160, 14);
		getContentPane().add(lblNewLabel_2);
		
		tfNameSurname = new JTextField();
		tfNameSurname.setBounds(180, 8, 244, 20);
		getContentPane().add(tfNameSurname);
		tfNameSurname.setColumns(10);
		
		tfExperienceYear = new JTextField();
		tfExperienceYear.setBounds(180, 78, 244, 20);
		getContentPane().add(tfExperienceYear);
		tfExperienceYear.setColumns(10);
		
		JComboBox cbMusicStyle = new JComboBox();
		cbMusicStyle.setBounds(180, 40, 244, 22);
		cbMusicStyle.setModel(new DefaultComboBoxModel(new String[] {"Pop", "Rock", "Jazz"}));
		getContentPane().add(cbMusicStyle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 414, 124);
		contentPane.add(scrollPane);
		
		JTextArea taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
		
		JButton btnAdd = new JButton("Add Musician");
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // add musician action performed (click) event
				MusicianSys.addMusician(tfNameSurname.getText(), cbMusicStyle.getSelectedItem().toString(), Integer.parseInt(tfExperienceYear.getText()));
				taResult.setText("Musician is added to the array!!");
			}
		});
		
		btnAdd.setBounds(10, 122, 120, 23);
		getContentPane().add(btnAdd);
		
		JButton btnCalculate = new JButton("Calculate & Display");
		
		btnCalculate.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { // calculate and display action performed (click) event
				MusicianSys.calculateHourlyWage();
				taResult.setText(MusicianSys.display());
			}
		});
		
		btnCalculate.setBounds(138, 122, 170, 23);
		getContentPane().add(btnCalculate);
		
		JButton btnSearch = new JButton("Search");
		
		btnSearch.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { // search action performed (click) event
				String result = "";
				Musician musician = MusicianSys.searchMusician(tfNameSurname.getText());
				if (musician != null) {
					result = musician.toString();
				} else {
					result = "There is NO Musician with this name and surname!";
				}
				taResult.setText(result);
			}
		});
		
		btnSearch.setBounds(318, 122, 106, 23);
		getContentPane().add(btnSearch);
	}
}
