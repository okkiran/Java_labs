package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import Classes.Media;
import Classes.MediaSys;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MediaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfSongName;
	private JTextField tfSongDuration;
	private JTextField tfSongArtist;
	private JTextField tfSongAlbum;
	private JTextField tfMovieName;
	private JTextField tfMovieDuration;
	private JTextField tfMovieDirector;
	private JTextField tfMovieStarring;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JComboBox cbMediaName;
	
	private RatingFrame ratingFrame = new RatingFrame(this);
	
	/**
	 * Create the frame.
	 */
	public MediaFrame() {
		setTitle("Media");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 294, 744, 236);
		contentPane.add(scrollPane);
		
		JTextArea taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
		
		JButton btnRead = new JButton("Read Media from File");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MediaSys.readFromFile("media.txt")) {
					taResult.setText("File read successful.");
					fillMediaNameComboBox();
				} else {
					taResult.setText("An exception occurred during file read!");
				}
			}
		});
		btnRead.setBounds(10, 11, 160, 23);
		contentPane.add(btnRead);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Display Media", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(420, 151, 334, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type:");
		lblNewLabel.setBounds(10, 27, 144, 14);
		panel.add(lblNewLabel);
		
		JComboBox cbType = new JComboBox();
		cbType.setBounds(144, 23, 60, 22);
		panel.add(cbType);
		cbType.setModel(new DefaultComboBoxModel(new String[] {"A", "S", "M"}));
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = MediaSys.getMediaList(cbType.getSelectedItem().toString());
				taResult.setText(result);
			}
		});
		btnDisplay.setBounds(214, 23, 110, 23);
		panel.add(btnDisplay);
		
		JLabel lblNewLabel_5 = new JLabel("(A: all, S: song, M: movie)");
		lblNewLabel_5.setBounds(10, 52, 314, 14);
		panel.add(lblNewLabel_5);
		
		JButton btnWrite = new JButton("Write Media to File");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MediaSys.writeToFile("media.txt")) {
					taResult.setText("File write successful.");
				} else {
					taResult.setText("An exception occurred during file write!");
				}
			}
		});
		btnWrite.setBounds(594, 11, 160, 23);
		contentPane.add(btnWrite);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 45, 400, 238);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Media Type to Add:");
		lblNewLabel_3.setBounds(10, 11, 115, 14);
		panel_2.add(lblNewLabel_3);
		
		JPanel panelSong = new JPanel();
		panelSong.setBounds(10, 36, 375, 160);
		panel_2.add(panelSong);
		panelSong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Song", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSong.setLayout(null);
		
		JPanel panelMovie = new JPanel();
		panelMovie.setBounds(10, 36, 375, 160);
		panel_2.add(panelMovie);
		panelMovie.setLayout(null);
		panelMovie.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Movie", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panelMovie.setVisible(false);
		
		JRadioButton rdbtnSong = new JRadioButton("Song");
		rdbtnSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSong.isSelected()) {
					panelSong.setVisible(true);
					panelMovie.setVisible(false);
				}
			}
		});
		buttonGroup.add(rdbtnSong);
		rdbtnSong.setSelected(true);
		rdbtnSong.setBounds(131, 7, 70, 23);
		panel_2.add(rdbtnSong);
		
		JRadioButton rdbtnMovie = new JRadioButton("Movie");
		rdbtnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMovie.isSelected()) {
					panelSong.setVisible(false);
					panelMovie.setVisible(true);
				}
			}
		});
		buttonGroup.add(rdbtnMovie);
		rdbtnMovie.setBounds(203, 7, 70, 23);
		panel_2.add(rdbtnMovie);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 28, 185, 14);
		panelSong.add(lblNewLabel_1);
		
		tfSongName = new JTextField();
		tfSongName.setBounds(205, 25, 150, 20);
		panelSong.add(tfSongName);
		tfSongName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duration:");
		lblNewLabel_1_1.setBounds(10, 57, 185, 14);
		panelSong.add(lblNewLabel_1_1);
		
		tfSongDuration = new JTextField();
		tfSongDuration.setBounds(205, 54, 150, 20);
		panelSong.add(tfSongDuration);
		tfSongDuration.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Artist:");
		lblNewLabel_2.setBounds(10, 103, 185, 14);
		panelSong.add(lblNewLabel_2);
		
		tfSongArtist = new JTextField();
		tfSongArtist.setColumns(10);
		tfSongArtist.setBounds(205, 100, 150, 20);
		panelSong.add(tfSongArtist);
		
		JLabel lblNewLabel_2_1 = new JLabel("Album:");
		lblNewLabel_2_1.setBounds(10, 134, 185, 14);
		panelSong.add(lblNewLabel_2_1);
		
		tfSongAlbum = new JTextField();
		tfSongAlbum.setColumns(10);
		tfSongAlbum.setBounds(205, 131, 150, 20);
		panelSong.add(tfSongAlbum);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("(hours:minutes:seconds)");
		lblNewLabel_1_1_1.setBounds(10, 77, 185, 14);
		panelSong.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setBounds(10, 28, 185, 14);
		panelMovie.add(lblNewLabel_1_2);
		
		tfMovieName = new JTextField();
		tfMovieName.setColumns(10);
		tfMovieName.setBounds(205, 25, 150, 20);
		panelMovie.add(tfMovieName);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Duration:");
		lblNewLabel_1_1_2.setBounds(10, 57, 185, 14);
		panelMovie.add(lblNewLabel_1_1_2);
		
		tfMovieDuration = new JTextField();
		tfMovieDuration.setColumns(10);
		tfMovieDuration.setBounds(205, 54, 150, 20);
		panelMovie.add(tfMovieDuration);
		
		JLabel lblNewLabel_2_2 = new JLabel("Director:");
		lblNewLabel_2_2.setBounds(10, 103, 185, 14);
		panelMovie.add(lblNewLabel_2_2);
		
		tfMovieDirector = new JTextField();
		tfMovieDirector.setColumns(10);
		tfMovieDirector.setBounds(205, 100, 150, 20);
		panelMovie.add(tfMovieDirector);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Starring:");
		lblNewLabel_2_1_1.setBounds(10, 134, 185, 14);
		panelMovie.add(lblNewLabel_2_1_1);
		
		tfMovieStarring = new JTextField();
		tfMovieStarring.setColumns(10);
		tfMovieStarring.setBounds(205, 131, 150, 20);
		panelMovie.add(tfMovieStarring);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("(hours:minutes:seconds)");
		lblNewLabel_1_1_1_1.setBounds(10, 77, 185, 14);
		panelMovie.add(lblNewLabel_1_1_1_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(215, 204, 89, 23);
		panel_2.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name, duration, artistOrDirector, albumOrStarring, type;
				
				if (rdbtnSong.isSelected()) {
					type = "S";
					name = tfSongName.getText();
					duration = tfSongDuration.getText();
					artistOrDirector = tfSongArtist.getText();
					albumOrStarring = tfSongAlbum.getText();
					
					if (name.isEmpty() || duration.isEmpty() || artistOrDirector.isEmpty() || albumOrStarring.isEmpty()) {
						taResult.setText("All fields are required for song!");
					} else {
						if (MediaSys.addMedia(type, name, duration, artistOrDirector, albumOrStarring)) {
							taResult.setText("Song added successfully.");
							clear();
							fillMediaNameComboBox();
						} else {
							taResult.setText("Song could not be added because media with the same name exists!");
						}
					}
				} else {
					type = "M";
					name = tfMovieName.getText();
					duration = tfMovieDuration.getText();
					artistOrDirector = tfMovieDirector.getText();
					albumOrStarring = tfMovieStarring.getText();
					
					if (name.isEmpty() || duration.isEmpty() || artistOrDirector.isEmpty() || albumOrStarring.isEmpty()) {
						taResult.setText("All fields are required for movie!");
					} else {
						if (MediaSys.addMedia(type, name, duration, artistOrDirector, albumOrStarring)) {
							taResult.setText("Movie added successfully.");
							clear();
							fillMediaNameComboBox();
						} else {
							taResult.setText("Movie could not be added because media with the same name exists!");
						}
					}
				}
			}
		});
		
		JPanel panelRating = new JPanel();
		panelRating.setBounds(420, 45, 334, 95);
		contentPane.add(panelRating);
		panelRating.setLayout(null);
		panelRating.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update Rating", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_4 = new JLabel("Media:");
		lblNewLabel_4.setBounds(10, 29, 46, 14);
		panelRating.add(lblNewLabel_4);
		
		cbMediaName = new JComboBox();
		cbMediaName.setBounds(66, 25, 258, 22);
		panelRating.add(cbMediaName);
		
		JButton btnUpdateRating = new JButton("Update");
		btnUpdateRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Media media = MediaSys.findMedia(cbMediaName.getSelectedItem().toString());
				ratingFrame.setMedia(media);
				ratingFrame.setVisible(true);
			}
		});
		btnUpdateRating.setBounds(66, 58, 89, 23);
		panelRating.add(btnUpdateRating);
	}
	
	public void clear() {
		tfSongName.setText("");
		tfSongDuration.setText("");
		tfSongArtist.setText("");
		tfSongAlbum.setText("");
		tfMovieName.setText("");
		tfMovieDuration.setText("");
		tfMovieDirector.setText("");
		tfMovieStarring.setText("");
	}
	
	public void fillMediaNameComboBox() {
        cbMediaName.setModel(new DefaultComboBoxModel(MediaSys.getMediaNames()));
    }
	
}
