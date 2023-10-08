
public class MusicianSys {
	
	// data members
	private static final int MAX_SIZE = 3; // assigning the constant value 3
    private static int count = 0; // assigning the initial value 0 to the array index named count
    private static Musician[] musicianList = new Musician[MAX_SIZE]; // array of type Musician with MAX_SIZE (3) elements

    // member methods
    // adds a musician by name and surname together, music style and experience year parameters
    public static boolean addMusician(String nameSurname, String musicStyle, int expYear) {  
    	
        if (count < MAX_SIZE) { // if array index named count is less than maximum size
            musicianList[count] = new Musician(nameSurname, musicStyle, expYear); // initialize the object
            count++; // increment count index for other elements
            return true; // return success result
        } 
        
        return false; // return error result    
        
    }

    // searches musician by name and surname together parameter
    public static Musician searchMusician(String nameSurname) {
    	
    	Musician foundMusician = null; // assuming musician is not found in the beginning
    	
        for (int i = 0; i < count; i++) { // iterating through array elements
        	
        	// if element's name and surname together equals to the nameSurname parameter
        	if (nameSurname.equalsIgnoreCase(musicianList[i].getNameSurname())) { 
        		
                foundMusician = musicianList[i]; // assign foundMusician reference variable by the element at i. index
                break; // terminate the loop since we don't need to iterate through other elements
                
            }
        	
        }
        
        return foundMusician;
        
    }

    // calculates the hourly wage of each element of type Musician of the array
    public static void calculateHourlyWage() {
        
    	// variable declarations
    	double wage;
        int expYear;
        
        for (int i = 0; i < count; i++) { // iterating through array elements
        	
            wage = 1000; // setting initial wage to 1000 for each iteration
            if (musicianList[i].getMusicStyle().equalsIgnoreCase("pop")) // if musician's music style is pop
                wage += 900; // increment wage by 900
            else if(musicianList[i].getMusicStyle().equalsIgnoreCase("rock")) // if musician's music style is rock
                wage += 700; // increment wage by 700
            else if(musicianList[i].getMusicStyle().equalsIgnoreCase("jazz")) // if musician's music style is jazz
                wage += 500; // increment wage by 500
               
            // if musician's experience year is greater than 2, then increment wage by the specified calculation
            expYear = musicianList[i].getExperienceYear();
            if (expYear > 2)
                wage += (100 * expYear);
            
            musicianList[i].setHourlyWage(wage); // set the wage of the musician element at i. index
        }
        
    }

    // displaying the array elements' information
    public static String display() {
    	
        String output = "";
        
        for (int i = 0; i < count; i++) {
            output += musicianList[i].toString() + "\n";
        }
        
        return output;
        
    }
    
}
