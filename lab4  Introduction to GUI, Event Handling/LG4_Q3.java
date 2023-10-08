import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class LG4_Q3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameSurname;
	private JTextField txtClick;
	private JTextField txtLike;
	private JTextField txtSubs;
	private JComboBox cmbSharing;
	
	double price;
	
	String imagesPath = "images/"; // path of the images folder in the project
	
	ImageIcon youtube = new ImageIcon(imagesPath + "youtube.png"); // path: images/youtube.png
    ImageIcon instagram = new ImageIcon(imagesPath + "instagram.png"); // path: images/instagram.png
    ImageIcon snapchat = new ImageIcon(imagesPath + "snapchat.png"); // path: images/snapchat.png
    
    private JLabel lblImage;
    private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LG4_Q3 frame = new LG4_Q3();
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
	public LG4_Q3() {
		setTitle("LG4 - Q3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("User Name Surname:");
		lblName.setBounds(50, 11, 160, 14);
		contentPane.add(lblName);
		
		txtNameSurname = new JTextField();
		txtNameSurname.setBounds(231, 8, 173, 20);
		contentPane.add(txtNameSurname);
		txtNameSurname.setColumns(10);
		
		JLabel lblMedia = new JLabel("Media Sharing Networks:");
		lblMedia.setBounds(50, 56, 160, 14);
		contentPane.add(lblMedia);
		
		cmbSharing = new JComboBox();
		
		// media sharing network action listener
		cmbSharing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // media sharing network action performed (change) event
				System.out.println(cmbSharing.getSelectedItem()); // print selected item's text to the console
				
				if (cmbSharing.getSelectedItem().equals("YouTube")) { // if YouTube is selected
					lblImage.setIcon(youtube); // change icon to YouTube's icon
		        } else if (cmbSharing.getSelectedItem().equals("Snapchat")) { // if Snapchat is selected
		        	lblImage.setIcon(snapchat); // change icon to Snapchat's icon 
		        } else { // if Instagram is selected
		        	lblImage.setIcon(instagram); // change icon to Instagram's icon
		        }  
			}
		});
		
		// media sharing network combo box items
		cmbSharing.setModel(new DefaultComboBoxModel(new String[] {"YouTube", "Instagram", "Snapchat"}));
		
		cmbSharing.setBounds(231, 52, 173, 22);
		contentPane.add(cmbSharing);
		
		lblImage = new JLabel("");
		lblImage.setIcon(youtube);
		lblImage.setBounds(284, 85, 83, 84);
		contentPane.add(lblImage);
		
		JLabel lblClick = new JLabel("Click:");
		lblClick.setBounds(52, 194, 38, 14);
		contentPane.add(lblClick);
		
		txtClick = new JTextField();
		txtClick.setBounds(89, 191, 61, 20);
		contentPane.add(txtClick);
		txtClick.setColumns(10);
		
		JLabel lblLike = new JLabel("Like:");
		lblLike.setBounds(160, 194, 30, 14);
		contentPane.add(lblLike);
		
		txtLike = new JTextField();
		txtLike.setBounds(200, 191, 48, 20);
		contentPane.add(txtLike);
		txtLike.setColumns(10);
		
		JLabel lblSubscription = new JLabel("Subscription:");
		lblSubscription.setBounds(280, 194, 87, 14);
		contentPane.add(lblSubscription);
		
		txtSubs = new JTextField();
		txtSubs.setBounds(360, 191, 44, 20);
		contentPane.add(txtSubs);
		txtSubs.setColumns(10);
		
		JButton btnEarning = new JButton("Calculate the User Earning");
		
		// calculate earning button's action listener
		btnEarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // calculate earning button's action performed (click) event 
				double clickRate, likeRate, subsRate; // click rate, like rate and subscription rate variables 
				
				int numofClick = Integer.parseInt(txtClick.getText().toString()); // number of clicks
		        int numofLike = Integer.parseInt(txtLike.getText().toString()); // number of likes
		        int numofSubs = Integer.parseInt(txtSubs.getText().toString()); // number of subscriptions
		        
		        // setting the initial text to the textArea
		        textArea.setText(txtNameSurname.getText() + "\n*************************\n" + "Media Sharing Network : " + cmbSharing.getSelectedItem().toString() + "\nThe User Earning : ");   
		       
		        if (cmbSharing.getSelectedItem().equals("YouTube")) { // if YouTube is selected
		        	// assigning the required values to the variables
		        	clickRate = 0.5;
		        	likeRate = 1.5;
		        	subsRate = 5;		            
		        } 
		        else if (cmbSharing.getSelectedItem().equals("Instagram")){	// if Instagram is selected	          
		        	// assigning the required values to the variables
		        	clickRate = 0.3;
		        	likeRate = 1;
		        	subsRate = 4;		            		        
		        }
		        else { // if Snapchat is selected
		        	// assigning the required values to the variables
		        	clickRate = 0.2;
		        	likeRate = 0.5;
		        	subsRate = 3;				        	
		        }

		        // calculation of the price
		        price = numofClick * clickRate + numofLike * likeRate + numofSubs * subsRate;
		        
		        if(price <= 0.0) // if price is less than or equal to 0
		            textArea.append("Sorry! There is NO earning :("); // appending no earning string to the textArea
		        else // if price is greater than 0
		            textArea.append("Congratulations! The user earned " + price + " TL :)"); // appending price string to the textArea
			}
		});
		
		btnEarning.setBounds(50, 219, 354, 23);
		contentPane.add(btnEarning);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 263, 354, 118);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
