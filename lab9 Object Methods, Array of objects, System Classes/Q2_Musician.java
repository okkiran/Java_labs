
public class Musician {
	
	// data members
	private String nameSurname;    
    private String musicStyle;
    private int experienceYear;
    private double hourlyWage;

    private static int numOfMusician = 0;

    // constructors
    public Musician(String nameSurname, String musicStyle, int experienceYear) {
        this.nameSurname = nameSurname;
        this.musicStyle = musicStyle;
        this.experienceYear = experienceYear;
        this.numOfMusician++;
    }
    
    // getters and setters
    public static int getMusicianCount() {
        return numOfMusician;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getMusicStyle() {
        return musicStyle;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
        return "Musician Name Surname : " + nameSurname 
        		+ "\nMusic Style : " + musicStyle 
        		+ "\nExperience Year : " + experienceYear 
        		+ "\nHourly Wage : " + hourlyWage + "\n";
    }   
    
}
