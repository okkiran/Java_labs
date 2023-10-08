package Classes;

public class Movie extends Media {
	
	private String director;
	private String starring;
	
	public Movie(String name, String duration, String director, String starring) {
		super(name, duration);
		this.director = director;
		this.starring = starring;
	}
	
	public String getDirector() {
		return director;
	}
	
	public String getStarring() {
		return starring;
	}
	
	@Override
	public void calculatePrice() {
		price = addVat(20);
	}
	
	@Override
	public String toString() {
		String result = "Movie\n";
		result += super.toString();
		result += "Director: " + director + "\nStarring: " + starring + "\n";
		return result;
	}

	@Override
	public double addVat(double priceWithoutVat) {
		return priceWithoutVat + priceWithoutVat * 0.18;
	}
	
}
