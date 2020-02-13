import java.util.Scanner;
/**
 * The class StateUtil contains the methods that are used to toggle the status for the onOff and toContinue objects as well as the method that closes the program
 * @author cdraper
 */
public class StateUtil {
	static Help HELP = Help.HELP;
	static Scanner scanner = new Scanner(System.in);
	/**
	 * The switchOnOff method takes the onOff object and based on the user input toggles the status to true or false, which will either turn the program on or off
	 * @param onOff - represents the onOff object that is passed in so that the state may be toggled
	 */
	public static void switchOnOff(OnOff onOff) {
		System.out.print("Enter HELP at any time for assistance.\n\nON/OFF: ");
		String input = scanner.nextLine();
		// the while loop runs until the user inputs either 'on' or 'off'
		while(!input.equalsIgnoreCase("on") && !input.equalsIgnoreCase("off")) {
			// if the user inputs 'help' then the help menu will be printed
			if(input.equalsIgnoreCase("help")) {
				System.out.print(HELP + "\n\nON/OFF: ");
				input = scanner.nextLine();
			// if the user inputs anything besides 'on', 'off', or 'help' they will be prompted again
			} else {
				System.out.print("Please enter either ON or OFF: ");
				input = scanner.nextLine();
			}
		}
		// if the user enters 'on' then the status is toggled to true
		if(input.equalsIgnoreCase("on")) {
			onOff.status = true;
		// if the user enters 'off' then the status is toggled to false
		} else if(input.equalsIgnoreCase("off")) {
			onOff.status = false;
		}
	}
	/**
	 * The switchToContinue method takes the toContinue object and based on the user input toggles the status to true or false, which will either continue to run the calculator
	 * or terminate the program
	 * @param toContinue - represents the toContinue object that is passed in so that the state may be toggled
	 */
	public static void switchToContinue(ToContinue toContinue) {
		System.out.print("\nDo you want to continue? (Yes/No): ");
		String input = scanner.nextLine();
		// the loop will run until the user enters either 'yes' or 'no'
		while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
			// if the user enters 'help' then the help menu will be printed
			if(input.equalsIgnoreCase("help")) {
				System.out.print(HELP + "\n\nDo you want to continue? (Yes/No): ");
				input = scanner.nextLine();
			// if the user enters anything other than 'yes', 'no', or 'help' then the prompt will be repeated
			} else {
				System.out.print("Please enter either Yes or No to continue: ");
				input = scanner.nextLine();
			}
		}
		// if the user enters 'no' then the status is toggled to false
		if(input.equalsIgnoreCase("no")) {
			toContinue.status = false;
		}
	}
	/**
	 * The closeProgram method toggles the status of the onOff object to false once the user selects to terminate the program. It also closes the scanner object and 
	 * notifies the user that the program has been terminated
	 * @param onOff - represents the onOff object that is passed in
	 */
	public static void closeProgram(OnOff onOff) {
		System.out.println("Program terminated");
		onOff.status = false;
		scanner.close();
	}

}
