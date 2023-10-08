
public class VitaminsMain_a {

	public static void main(String[] args) {
		
		// initialization of vitamin objects of type Vitamins
		Vitamins vitamins1 = new Vitamins(); // initialization with no-arg constructor
		Vitamins vitamins2 = new Vitamins("B12", 65, "Eczacibasi", 1236545); // initialization with non-default constructor
		Vitamins vitamins3 = new Vitamins("Folik Acid", 52, "Quali-Blends", 3566455); // initialization with non-default constructor
		
		// displaying the vitamin information by invoking the toString method
		System.out.println(vitamins1.toString());
		 
		// since we have overridden the toString method in the Vitamins class,
		// the toString method will be automatically invoked even we use objects as parameters 
		System.out.println(vitamins2);
		System.out.println(vitamins3);

	}

}
