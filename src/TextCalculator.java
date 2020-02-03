import java.util.InputMismatchException;
import java.util.Scanner;

public class TextCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		OnOff onOff = new OnOff();
		
		System.out.print("ON/OFF: ");
		onOff.status = scanner.nextLine();
		
		while(onOff.status.equalsIgnoreCase("on")) {
		
			System.out.print("Do you want to continue? (Yes/No): ");
			String toContinue = scanner.nextLine().toLowerCase();
			
			if(!toContinue.equals("yes") && !toContinue.equals("no")) {
				System.out.println("Please enter either Yes or No to continue.");
			} else if(toContinue.equals("yes")) {
				try {
					while(toContinue.equals("yes")) {
						
						System.out.print("Please enter the first number: ");
						Double firstDouble = scanner.nextDouble();
						
						System.out.print("Please enter the desired operator: ");
						String operatorInput = scanner.next();
						char operator = operatorInput.charAt(0);
						
						System.out.print("Please enter the second number: ");
						Double secondDouble = scanner.nextDouble();
						
						System.out.println("Result: " + calculateResult(firstDouble, secondDouble, operator));
						scanner.nextLine();
						
						System.out.print("\nDo you want to continue? (Yes/No): ");
						toContinue = scanner.nextLine().toLowerCase();
					}
				} catch(InputMismatchException e) {
					System.out.println("You have entered an unexpected value. Please only enter appropriate values for each line. If you need further assistance please type HELP at any time.");
					System.err.println(e.toString());
				} finally {
					closeProgram(scanner, onOff);
				}
			} else if(toContinue.equals("no")) {
				closeProgram(scanner, onOff);
			} 
		}
	}
	
	
	public static Double doAddition(Double num1, Double num2) {
		return num1 + num2;
	}
	
	public static Double doSubstraction(Double num1, Double num2) {
		return num1 - num2;
	}
	
	public static Double doMultiplication(Double num1, Double num2) {
		return num1 * num2;
	}
	
	public static Double doDivision(Double num1, Double num2) {
		return num1 / num2;
	}
	
	public static Double doModulo(Double num1, Double num2) {
		return num1 % num2;
	}
	
	public static Double doRaise(Double num1, Double num2) {
		return Math.pow(num1, num2);
	}
	
	public static Double doRoot(Double num1, Double num2) {
		return Math.pow(num1, 1/num2);
	}
	
	public static Double calculateResult(Double num1, Double num2, char operator) {
		Double result = null;
		
		if(operator == '+') {
			result = doAddition(num1, num2);
		} else if(operator == '-') {
			result = doSubstraction(num1, num2);
		} else if(operator == '*') {
			result = doMultiplication(num1, num2);
		} else if(operator == '/') {
			result = doDivision(num1, num2);
		} else if(operator == '%') {
			result = doModulo(num1, num2);
		} else if(operator == '^') {
			result = doRaise(num1, num2);
		} else if(operator == '~') {
			result = doRoot(num1, num2);
		} else {
			System.out.print("Can't compute. Self destruct initiated...\n");
		}
		return result;
	}
	
	public static void closeProgram(Scanner scanner, OnOff onOff) {
		System.out.println("Program terminated");
		onOff.status = "off";
		scanner.close();
	}
	

}
