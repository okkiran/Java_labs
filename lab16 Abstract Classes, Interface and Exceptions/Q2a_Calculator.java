
public class Calculator {

	public static String calculate(String numerator, String denominator) {
        String message = "";
        int numeratorNumber, denominatorNumber, result;
        
        numeratorNumber = Integer.parseInt(numerator);
    	denominatorNumber = Integer.parseInt(denominator);
        result = numeratorNumber / denominatorNumber;
        message = "\nResult: " + numeratorNumber + " / " + denominatorNumber + " = " + result;
        
        return message;
    }
	
}
