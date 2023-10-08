
public class LG2_AQ2 {

	public static void main(String[] args) {
		
		// declaration of variables
		double celsius, fahrenheit;
		
		// displaying conversion from Celsius to Fahrenheit header
		System.out.println("Fahrenheit Equivalent from 0 to 50 Celsius\n");
		System.out.println("Degrees in Celsius        Degrees in Fahrenheit");
		System.out.println("-----------------------------------------------");
		
		// iteration of c (Celsius) loop variable starting from 0 to 50 and incrementing by 5
		for (int c = 0; c <= 50; c += 5) {
			
			fahrenheit = convertToFahrenheit(c); // conversion of Celsius to Fahrenheit
			
			System.out.printf("%-2d", c); // displaying Celsius value with padding 2 characters left
			System.out.printf("%24c", ' '); // displaying 24 space characters
			System.out.printf("%.2f", fahrenheit); // displaying Fahrenheit value with 2 decimal digits
			System.out.println(); // displaying new line
		}
		
		System.out.println(); // displaying new line
		
		// displaying conversion from Fahrenheit to Celsius header
		System.out.println("Celsius Equivalent from 32 to 140 Fahrenheit\n");
		System.out.println("Degrees in Fahrenheit     Degrees in Celsius");
		System.out.println("-----------------------------------------------");
		
		// iteration of f (Fahrenheit) loop variable starting from 32 to 140 and incrementing by 18
		for (int f = 32; f <= 140; f += 18) {
			
			celsius = convertToCelsius(f); // conversion of Fahrenheit to Celsius
			
			System.out.printf("%-3d", f); // displaying Fahrenheit value with padding 3 characters left
			System.out.printf("%23c", ' '); // displaying 23 space characters
			System.out.printf("%.2f", celsius); // displaying Celsius value with 2 decimal digits
			System.out.println(); // displaying new line
		}
		
	}
	
	// method for the conversion of Fahrenheit to Celsius
	public static double convertToCelsius(double fahrenheit) {
		return 5.0 / 9.0 * (fahrenheit - 32.0);
	}
	
	// method for the conversion of Celsius to Fahrenheit
	public static double convertToFahrenheit(double celsius) {
		return 9.0 * celsius / 5.0 + 32.0;
	}

}
