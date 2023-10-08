
public class Calculator {

	public static String calculate(String numerator, String denominator) {
        String message = "";
        int numeratorNumber, denominatorNumber, result;
        
        try {
        	numeratorNumber = Integer.parseInt(numerator);
        	denominatorNumber = Integer.parseInt(denominator);
            result = numeratorNumber / denominatorNumber;
            message = "\nResult: " + numeratorNumber + " / " + denominatorNumber + " = " + result;
        } catch (NumberFormatException numberFormatException) {
        	message = "\nException:" + numberFormatException;
        	message += "\nYou must enter integers.\nPlease try again.\n";
        } catch (ArithmeticException arithmeticException) {
        	message = "\nException:" + arithmeticException;
        	message += "\nZero is an invalid denominator.\nPlease try again\n";
        }

        return message;
    }
	
}
