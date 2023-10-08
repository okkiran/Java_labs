
public class Course {
	
	// data members
	private String courseLevel;
	private int numOfHour;
	private double weeklyPrice;

	// constructors
	public Course(String courseLevel, int numOfHour, double weeklyPrice) {
		this.courseLevel = courseLevel;
		this.numOfHour = numOfHour;
		this.weeklyPrice = weeklyPrice;
	}

	// getters
	public double getWeeklyPrice(){
		return weeklyPrice;		
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "\nCourse Level : " + courseLevel + "\nNum Of Hour : " + numOfHour + "\nPrice : " + weeklyPrice;
	}
	
}
