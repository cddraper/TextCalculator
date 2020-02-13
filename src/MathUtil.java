import java.util.Scanner;
/**
 * The MathUtil class contains all of the mathematical logic for the calculator as well as the key method which combines the logic to run the calculator
 * @author cdraper
 */
public class MathUtil {
	
	static Help HELP = Help.HELP;
	static Scanner scanner = new Scanner(System.in);
	/**
	 * The doAddition method is used to take input from the user and perform simple addition operations
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doAddition(Double num1, Double num2) {
		return num1 + num2;
	}
	/**
	 * The doSubtraction method is used to take input from the user and perform simple subtraction operations
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doSubtraction(Double num1, Double num2) {
		return num1 - num2;
	}
	/**
	 * The doMultiplication method is used to take input from the user and perform simple multiplication operations
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doMultiplication(Double num1, Double num2) {
		return num1 * num2;
	}
	/**
	 * The doDivision method is used to take input from the user and perform simple division operations. It also notifies the user if they attempt to divide by 0 or -0.
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doDivision(Double num1, Double num2) {
		if(num2 == 0 || num2 == -0) {
			System.out.println("Cannot divide by zero.");
		}
		return num1 / num2;
	}
	/*
	 * The doModulo method is used to take input from the user and performs modulo operations where the first number is divided by the second number, then the remainder is returned
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doModulo(Double num1, Double num2) {
		return num1 % num2;
	}
	/**
	 * The doRaise method is used to take input from the user and raises the first number from the user to the power of the second number from the user
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doRaise(Double num1, Double num2) {
		return Math.pow(num1, num2);
	}
	/**
	 * The doRoot method is used to take input from the user and finds the nth root of the first number, where the second number = n
	 * @param num1 - the first number in the equation
	 * @param num2 - the second number in the equation
	 * @return - returns the result of the equation
	 */
	public static Double doRoot(Double num1, Double num2) {
		return Math.pow(num1, 1/num2);
	}
	/**
	 * The calculateResult method checks the user input to see which operation they are performing and then calls the relevant method to calculate the result. 
	 * It will also tell the user if they have entered an invalid operator.
	 * @param num1 - the first number to be used in the equation
	 * @param num2 - the second number to be used in the equation
	 * @param operator- represents the operator that the user wishes to use in the equation
	 * @return - returns the result of the equation
	 */
	public static Double calculateResult(Double num1, Double num2, char operator) {
		Double result = null;
		
		switch(operator) {
		case '+': result = doAddition(num1, num2);
		break;
		case '-': result = doSubtraction(num1, num2);
		break;
		case '*': result = doMultiplication(num1, num2);
		break;
		case '/': result = doDivision(num1, num2);
		break;
		case '%': result = doModulo(num1, num2);
		break;
		case '^': result = doRaise(num1, num2);
		break;
		case '~': result = doRoot(num1, num2);
		break;
		default: System.out.print("Invalid operator entered. Cannot compute...\n");
		}
		return result;
	}
	/**
	 * The runCalculator method is the key method that combines the logic from the other methods to take user input, run the calculation, and return the relevant information.
	 * It also manipulates the state of the toContinue object based on input from the user whether they want to continue the program or not.
	 * @param toContinue - this parameter passes in the toContinue object so that the user has access to manipulate the status class variable and toggle it to off to terminate the program
	 */
	public static void runCalculator(ToContinue toContinue) {
		// the String variables operOut, firstOut and secondOut are passed in to the checkHelp function to customize the text output to the user based on the step the user is on
		String operOut = "\n\nPlease enter the desired operator: ";
		String firstOut = "\n\nPlease enter the first number: ";
		String secondOut = "\n\nPlease enter the second number: ";
		// this loop will continuously run the calculator until the user changes the toContinue status to false by entering 'no' when prompted to continue
		while(toContinue.status) {
			/* this block takes in the first number from the user, runs checkHelp to see if the user is requesting the help menu, then runs 
				checkSpecial to determine if the user is trying to use either 'PI' or 'e' as a numeric input */
			System.out.print("\nPlease enter the first number: ");
			String firstNumInput = Help.checkHelp(firstOut);
			Double firstDouble = checkSpecial(firstNumInput);
			// this block takes the operator input from the user, runs checkHelp to determine if user is requesting help menu, then converts the operator into a char
			System.out.print("Please enter the desired operator: ");
			String operatorInput = Help.checkHelp(operOut);
			char operator = operatorInput.charAt(0);
			/* this block takes in the second number from the user, runs checkHelp to see if the user is requesting the help menu, then runs
				checkSpecial to determine if the user is trying to use either 'PI' or 'e' as a numeric input */
			System.out.print("Please enter the second number: ");
			String secondNumInput = Help.checkHelp(secondOut);
			Double secondDouble = checkSpecial(secondNumInput);
			// the result of the equation is calculated by passing the input from the user into calculateResult and then printed to the user
			System.out.println("Result: " + calculateResult(firstDouble, secondDouble, operator));
			StateUtil.switchToContinue(toContinue);
		}
	}
	/**
	 * The checkSpecial method is run when the user enters numeric input and is used to check for the special values
	 * of 'pi' and 'e'. If these values are input the method will convert these to their respective numeric values
	 * @param input - takes the user input
	 * @return - returns the appropriate value, either the numeric user input, or the equivalent value for 'pi' or 'e', based on the user input
	 */
	public static Double checkSpecial(String input) {
		if(input.equalsIgnoreCase("pi")) {
			return Math.PI;
		} else if(input.equalsIgnoreCase("e")) {
			return Math.exp(1);
		}
		else {
			return Double.parseDouble(input);
		}
	}
}
