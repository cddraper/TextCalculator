import java.util.InputMismatchException;
import java.util.Scanner;

public class TextCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Help help = Help.HELP;
		
		OnOff onOff = new OnOff();
		ToContinue toContinue = new ToContinue();
		
		System.out.print("Enter HELP at any time for assistance.\n\n");
		
		System.out.print("ON/OFF: ");

		switchOnOff(scanner, onOff, help);
		
		if(!onOff.status) {
			closeProgram(scanner, onOff);
		}
		
		while(onOff.status) {
		
			if(toContinue.status == null) {
				toContinue.status = true;
			}
			else {
				System.out.print("Do you want to continue? (Yes/No): ");
				switchToContinue(scanner, toContinue, help);
			}
			
			while(toContinue.status) {
				try {
					runCalculator(scanner, toContinue, help);
				} catch(InputMismatchException e) {
					scanner.nextLine();
					System.out.println("You have entered an unexpected value. Please only enter appropriate values for each line. If you need further assistance please type HELP at any time.");
//					System.err.println(e.toString());
					System.out.print("\nDo you want to continue? (Yes/No): ");
					switchToContinue(scanner, toContinue, help);
				} catch(NumberFormatException e) {
					System.out.println("You have entered a non-numeric value. Please only enter numeric values. If you need further assistance please type HELP at any time.");
					System.out.print("\nDo you want to continue? (Yes/No): ");
					switchToContinue(scanner, toContinue, help);
				}
			} 
			closeProgram(scanner, onOff);
		} 	
	}
	
	
	
	public static Double doAddition(Double num1, Double num2) {
		return num1 + num2;
	}
	
	public static Double doSubtraction(Double num1, Double num2) {
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
		case '~': result = doRoot(num1, num2);
		break;
		default: System.out.print("Invalid operator entered. Cannot compute...\n");
		}
		return result;
	}
		
//		if(operator == '+') {
//			result = doAddition(num1, num2);
//		} else if(operator == '-') {
//			result = doSubtraction(num1, num2);
//		} else if(operator == '*') {
//			result = doMultiplication(num1, num2);
//		} else if(operator == '/') {
//			result = doDivision(num1, num2);
//		} else if(operator == '%') {
//			result = doModulo(num1, num2);
//		} else if(operator == '^') {
//			result = doRaise(num1, num2);
//		} else if(operator == '~') {
//			result = doRoot(num1, num2);
//		} else {
//			System.out.print("Can't compute. Self destruct initiated...\n");
//		}
//		return result;
	
	public static void closeProgram(Scanner scanner, OnOff onOff) {
		System.out.println("Program terminated");
		onOff.status = false;
		scanner.close();
	}
	
	public static void runCalculator(Scanner scanner, ToContinue toContinue, Help help) {
		if(toContinue.status == null) {
			toContinue.status = true;
		}
		
		while(toContinue.status) {
			
			System.out.print("\nPlease enter the first number: ");
			String firstNumInput = scanner.nextLine();
			while(firstNumInput.equalsIgnoreCase("help")) {
				System.out.print(help + "\n\nPlease enter the first number: ");
				firstNumInput = scanner.nextLine();
			}
			Double firstDouble = checkForPi(firstNumInput);
			
			System.out.print("Please enter the desired operator: ");
			String operatorInput = checkHelp(scanner, help);
			char operator = operatorInput.charAt(0);
			
			System.out.print("Please enter the second number: ");
			String secondNumInput = scanner.nextLine();
			while(secondNumInput.equalsIgnoreCase("help")) {
				System.out.print(help + "\n\nPlease enter the second number: ");
				secondNumInput = scanner.nextLine();
			}
			Double secondDouble = checkForPi(secondNumInput);
			
			System.out.println("Result: " + calculateResult(firstDouble, secondDouble, operator));
			
			System.out.print("\nDo you want to continue? (Yes/No): ");
			String input = scanner.nextLine();
			while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("help")) {
				System.out.println("Please enter either Yes or No to continue.");
				input = scanner.nextLine();
			}
			while(input.equalsIgnoreCase("help") || (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))) {
				if(input.equalsIgnoreCase("help")) {
					System.out.print(help + "\n\nDo you want to continue? (Yes/No): ");
					input = scanner.nextLine();
				} else {
					System.out.print("Please enter either Yes or No to continue: ");
					input = scanner.nextLine();
				}
			}
			if(input.equalsIgnoreCase("no")) {
				toContinue.status = false;
			}
		}
	}
	
	public static void switchOnOff(Scanner scanner, OnOff onOff, Help help) {
		String input = scanner.nextLine();
		while(!input.equalsIgnoreCase("on") && !input.equalsIgnoreCase("off") && !input.equalsIgnoreCase("help")) {
			System.out.print("Please enter either ON or OFF: ");
			input = scanner.nextLine();
			}
		while(input.equalsIgnoreCase("help") || (!input.equalsIgnoreCase("on") && !input.equalsIgnoreCase("off"))) {
			if(input.equalsIgnoreCase("help")) {
				System.out.print(help + "\n\nON/OFF: ");
				input = scanner.nextLine();
			} else {
				System.out.print("Please enter either ON or OFF: ");
				input = scanner.nextLine();
			}
		}
		if(input.equalsIgnoreCase("on")) {
			onOff.status = true;
		} else if(input.equalsIgnoreCase("off")) {
			onOff.status = false;
		}
	}
	
	public static void switchToContinue(Scanner scanner, ToContinue toContinue, Help help) {
		String input = scanner.nextLine();
		while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("help")) {
			System.out.print("Please enter either Yes or No to continue: ");
			input = scanner.nextLine();
		}
		while(input.equalsIgnoreCase("help") || (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))) {
			if(input.equalsIgnoreCase("help")) {
				System.out.print(help + "\n\nDo you want to continue? (Yes/No): ");
				input = scanner.nextLine();
			} else {
				System.out.print("Please enter either Yes or No to continue: ");
				input = scanner.nextLine();
			}
		}
		if(input.equalsIgnoreCase("yes")) {
			toContinue.status = true;
		}
		else if(input.equalsIgnoreCase("no")) {
			toContinue.status = false;
		}
	}
	
	public static Double checkForPi(String input) {
		if(input.equalsIgnoreCase("pi")) {
			return Math.PI;
		}
		else {
			return Double.parseDouble(input);
		}
	}
	
	public static void printHelp(Help help, Scanner scanner) {
		System.out.print(help + "\n\nON/OFF: ");
		String input = scanner.nextLine();
		while(input.equalsIgnoreCase("help")) {
			System.out.print(help);
		}
		while(!input.equalsIgnoreCase("on") && !input.equalsIgnoreCase("off") && !input.equalsIgnoreCase("help")) {
			System.out.print("Please enter either ON or OFF: ");
			input = scanner.nextLine();
		}
	}
	
	public static String checkHelp(Scanner scanner, Help help) {
		String input = scanner.nextLine();
		while(input.equalsIgnoreCase("help")) {
			System.out.print(help + "\n\nPlease enter the desired operator: ");
			input = scanner.nextLine();
		}
		return input;
	}

}
