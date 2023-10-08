package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaSys {

	private static ArrayList<Media> mediaList = new ArrayList<Media>();
	
	public static Media findMedia(String name) {
		
		Media foundMedia = null;
		
		for (Media media : mediaList) {
			if (media.findName(name)) {
				foundMedia = media;
				break;
			}
		}
		
		return foundMedia;
	}
	
	public static boolean addMedia(String type, String name, String duration, String directorOrArtist, String starringOrAlbum) {
		
		Media media;
		Rating rating;
		
		if (findMedia(name) != null) {
			return false;
		}
		
		if (type.equalsIgnoreCase("m")) { // movie
			media = new Movie(name, duration, directorOrArtist, starringOrAlbum);
		} else { // song
			media = new Song(name, duration, directorOrArtist, starringOrAlbum);
		}
		
		media.calculatePrice();
		
		mediaList.add(media);
		
		return true;
	}
	
	
	
	public static String getMediaList(String type) { // a: all, m: movie, s: song
		
		String result = "";
		Media media;
		
		for (int i = 0; i < mediaList.size(); i++) {
			media = mediaList.get(i);
			
			if (type.equalsIgnoreCase("m") && media instanceof Movie) {
				result += ((Movie)media).toString() + "\n";
			} else if (type.equalsIgnoreCase("s") && media instanceof Song) {
				result += ((Song)media).toString() + "\n";
			} else if (type.equalsIgnoreCase("a")) {
				result += media.toString() + "\n";
			}
		}
		
		return result;
	}
	
	public static String[] getMediaNames() {
		
		String[] result = new String[mediaList.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = mediaList.get(i).getName();
		}
		
		return result;
		
	}
	
	public static boolean readFromFile(String fileName) {
		
		try {
			mediaList = new ArrayList<Media>();
			
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			String[] splittedLine;
			Media media;
			Rating rating;
			String type, name, duration, directorOrArtist, starringOrAlbum;
			
			while (scanner.hasNextLine()) {
				splittedLine = scanner.nextLine().split("%");
				
				type = splittedLine[0];
				name = splittedLine[1];
				duration = splittedLine[2];
				directorOrArtist = splittedLine[3];
				starringOrAlbum = splittedLine[4];
				rating = new Rating(Integer.parseInt(splittedLine[5]), Integer.parseInt(splittedLine[6]), Integer.parseInt(splittedLine[7]));
				
				if (type.equalsIgnoreCase("m")) {
					media = new Movie(name, duration, directorOrArtist, starringOrAlbum);
				} else {
					media = new Song(name, duration, directorOrArtist, starringOrAlbum);
				}
				
				media.setRating(rating);
				
				media.calculatePrice();
				
				mediaList.add(media);
			}
			
			return true;
		}
		catch (Exception exc) {
			System.out.println(exc);
			return false;
		}
		
	}

	// Example: for appending a line for one object using PrintWriter and FileWriter 
	// assuming that we added only one media to the array list before, therefore we implement 
	// this method by getting the last added element of the array list
	/*
	public static boolean writeToFile(String fileName) {
		
		String line = "\n";
		Movie movie;
		Song song;
		Media lastMedia = null;
		
		File file;
		FileWriter fileWriter;
		PrintWriter printWriter = null;
		
		try {
			file = new File(fileName);
			
			fileWriter = new FileWriter(file, true); // will append
			
			printWriter = new PrintWriter(fileWriter);
			
			if (mediaList.size() > 0) { // if there are elements in the array list
				lastMedia = mediaList.get(mediaList.size() - 1); // get the last element of the array list
			
				if (lastMedia instanceof Movie) {
					movie = (Movie)lastMedia;
					line += "M%" + movie.getName() + "%" + movie.getDuration() + "%" + movie.getDirector() + "%" + movie.getStarring() + "%";
					line += movie.rating.getValue() + "%" + movie.rating.getYear() + "%" + movie.rating.getMonth();
				} else {
					song = (Song)lastMedia;
					line += "S%" + song.getName() + "%" + song.getDuration() + "%" + song.getArtist() + "%" + song.getAlbum() + "%";
					line += song.rating.getValue() + "%" + song.rating.getYear() + "%" + song.rating.getMonth();
				}
				
				printWriter.print(line);
			}
			
			return true;
		}
		catch (FileNotFoundException exc) {
			System.out.println(exc);
		}
		catch (IOException exc) {
			System.out.println(exc);
		}
		finally {
			if (printWriter != null) { // for preventing null reference exception
				printWriter.close();
			}
		}
		
		return false;
		
	}
	*/
	
	/* for overwriting a file with the array list elements using PrintWriter */
	public static boolean writeToFile(String fileName) {
		 
		String line;
		Movie movie;
		Song song;
		
		File file = new File(fileName);
		
		if (!file.exists()) {
			System.out.println("File could not be found.");
			return false;
		}
		
		PrintWriter printWriter = null;
		
		try {
			printWriter = new PrintWriter(file); // will overwrite
			
			for (Media media : mediaList) {
				if (media instanceof Movie) {
					movie = (Movie)media;
					line = "M%" + movie.getName() + "%" + movie.getDuration() + "%" + movie.getDirector() + "%" + movie.getStarring() + "%";
					line += movie.rating.getValue() + "%" + movie.rating.getYear() + "%" + movie.rating.getMonth();
				} else {
					song = (Song)media;
					line = "S%" + song.getName() + "%" + song.getDuration() + "%" + song.getArtist() + "%" + song.getAlbum() + "%";
					line += song.rating.getValue() + "%" + song.rating.getYear() + "%" + song.rating.getMonth();
				}
				
				printWriter.println(line);
			}
			
			return true;
		}
		catch (Exception exc) {
			System.out.println(exc);
		}
		finally {
			if (printWriter != null) { // for preventing null reference exception
				printWriter.close();
			}
		}
		
		return false;
		
	}
	
	public static void addRating(String name, int value, int year, int month) {
		
		Media foundMedia = null;
		Rating rating;
		
		for (Media media : mediaList) {
			if (media.findName(name)) {
				foundMedia = media;
				break;
			}
		}
		
		if (foundMedia != null) {
			rating = new Rating(value, year, month);
			foundMedia.setRating(rating);
		}
		
	}

}
