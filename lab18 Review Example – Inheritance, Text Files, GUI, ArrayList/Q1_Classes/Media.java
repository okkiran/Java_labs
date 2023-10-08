package Classes;

public abstract class Media implements Vat  {
	
	protected String name;
	protected String duration; // for movie hours:minutes:seconds, for song mintues:seconds format 
	protected double price;
	protected Rating rating;
	
	public Media(String name, String duration) {
		this.name = name;
		this.duration = duration;
		this.rating = new Rating();
	}
	
	public boolean findName(String name) {
		return this.name.equalsIgnoreCase(name);
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		String result = "Name: " + name + "\nDuration: " + duration + "\n";
		result += "Price: " + price + "\n" + rating.toString() + "\n";
		return result;
	}
	
	public abstract void calculatePrice();
	
}