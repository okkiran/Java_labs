import java.util.Scanner;

public class GymMember {
	
	// data members
	private String name;
    private int id;
    private int age;
    private double weight;
    private double idealWeight;
    private double fee;

    private static int lastUsedId = 1000; // initial value assignment
    
    // constructors
    public GymMember() {
        this.id = lastUsedId++; // increment the lastUsedId static field and assign it to the id field for unique ids
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getIdealWeight() {
        return idealWeight;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // member methods
    public void getInput() {
        
    	// for getting user input
        Scanner scanner = new Scanner(System.in);
    	
        System.out.print("Enter member name: ");
        name = scanner.nextLine();
        System.out.print("Enter member's age: ");
        age = scanner.nextInt();
        System.out.print("Enter current weight: ");
        weight = scanner.nextDouble();
        System.out.print("Enter ideal weight: ");
        idealWeight = scanner.nextDouble();
        
    }

    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
        return "\nGym Member"
	        + "\nName= " + name
	        + "\nId= " + id
	        + "\nAge= " + age
	        + "\nWeight= " + weight
	        + "\nIdeal Weight= " + idealWeight
	        + "\nFee= " + fee;
    }
    
}
