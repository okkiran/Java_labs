package Classes;

public class Rating {

	private int value; // between 1 and 5
	private int year;
	private int month;

	public Rating(int value, int year, int month) {
		this.value = value;
		this.year = year;
		this.month = month;
	}
	
	public Rating() {
		
	}
	
	public int getValue() {
		return value;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	@Override
	public String toString() {
		return "Rating value: " + value + "\nRating date: " + year + "/" + month;
	}
}