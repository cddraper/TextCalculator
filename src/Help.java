
public enum Help {
	HELP;
	
	@Override
	public String toString() {
		String help = "\n***********************\n"
				+ "       Help Menu\n"
				+ "***********************\n\n"
				+ "On program start, enter ON to launch the calculator, or OFF to close it.\n\n"
				+ "When prompted for a first and second number for the equation, you must only enter numeric values (decimal places are allowed).\n"
				+ "If you enter a non-numeric value, a message will state that you have entered an invalid-value, and you will be prompted with the option to contine.\n\n"
				+ "When presented with the option to continue, you must enter either Yes or No. If you enter any other value a new prompt will appear\n"
				+ "informing you to enter either Yes or No. This prompt will recur until either a value of Yes or No is entered.\n\n"
				+ "When prompted to enter the desired operator, only the following values will be accepted:\n"
				+ "The + operator is used for addition.\n"
				+ "The - operator is used for subtraction.\n"
				+ "The * operator is used for multiplication.\n"
				+ "The / operator is used for division.\n"
				+ "The % operator is used for modulo.\n"
				+ "The ^ operator is used to raise to an exponent.\n"
				+ "The ~ operator is used to find a root.\n"
				+ "If any other value is entered for the operator, the result of the equation will be null.\n\n"
				+ "To terminate the program, just enter No when prompted to continue.\n\n"
				+ "***********************";
		return help;
	}
}
