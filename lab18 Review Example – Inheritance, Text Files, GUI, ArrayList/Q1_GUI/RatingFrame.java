package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Media;
import Classes.Rating;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RatingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfValue;
	private JTextField tfYear;
	private JTextField tfMonth;
	
	JLabel lblMediaName;
	JLabel lblResult;
	
	Media media = null;

	/**
	 * Create the frame.
	 */
	public RatingFrame(MediaFrame mediaFrame) {
		setTitle("Update Rating");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Value:");
		lblNewLabel_1_3.setBounds(10, 45, 80, 14);
		contentPane.add(lblNewLabel_1_3);
		
		tfValue = new JTextField();
		tfValue.setColumns(10);
		tfValue.setBounds(100, 42, 89, 20);
		contentPane.add(tfValue);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Year:");
		lblNewLabel_1_1_3.setBounds(10, 76, 80, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(100, 73, 89, 20);
		contentPane.add(tfYear);
		
		tfMonth = new JTextField();
		tfMonth.setColumns(10);
		tfMonth.setBounds(100, 104, 89, 20);
		contentPane.add(tfMonth);
		
		JLabel lblNewLabel_2_3 = new JLabel("Month:");
		lblNewLabel_2_3.setBounds(10, 107, 80, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(245, 222, 179));
		panel_1.setBounds(10, 136, 339, 20);
		contentPane.add(panel_1);
		
		lblResult = new JLabel("");
		lblResult.setBackground(SystemColor.info);
		lblResult.setBounds(0, 0, 339, 20);
		panel_1.add(lblResult);
		
		JButton btnSaveRating = new JButton("Save");
		btnSaveRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (media == null) {
					lblResult.setText("Media could not be found!");
				} else {
					Rating rating = new Rating(Integer.parseInt(tfValue.getText()), Integer.parseInt(tfYear.getText()), Integer.parseInt(tfMonth.getText()));
					media.setRating(rating);
					lblResult.setText("Rating updated successfully.");
				}
			}
		});
		btnSaveRating.setBounds(100, 167, 89, 23);
		contentPane.add(btnSaveRating);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Media Name:");
		lblNewLabel_1_3_1.setBounds(10, 11, 80, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(100, 11, 249, 20);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblMediaName = new JLabel("");
		lblMediaName.setBounds(0, 0, 249, 20);
		panel.add(lblMediaName);
		lblMediaName.setBackground(new Color(255, 255, 225));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(199, 167, 89, 23);
		contentPane.add(btnClose);
	}
	
	public void setMedia(Media media) {
		this.media = media;
		lblMediaName.setText(media.getName());
		tfValue.setText("" + media.getRating().getValue());
		tfYear.setText("" + media.getRating().getYear());
		tfMonth.setText("" + media.getRating().getMonth());
		lblResult.setText("");
	}
	
}
