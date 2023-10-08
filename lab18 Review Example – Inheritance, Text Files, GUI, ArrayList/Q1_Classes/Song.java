package Classes;

public class Song extends Media {

	private String artist;
	private String album;
	
	public Song(String name, String duration, String artist, String album) {
		super(name, duration);
		this.artist = artist;
		this.album = album;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	@Override
	public void calculatePrice() { 
		price = addVat(1);
	}
	
	@Override
	public String toString() {
		String result = "Song\n";
		result += super.toString();
		result += "Artist: " + artist + "\nAlbum: " + album + "\n";
		return result;
	}

	@Override
	public double addVat(double priceWithoutVat) {
		return priceWithoutVat + priceWithoutVat * 0.1;
	}
	
}