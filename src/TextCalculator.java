/** 
 * The TextCalculator can perform simple mathematical calculations based on values input from the user.
 * @author cdraper
 */
public class TextCalculator {

	public static void main(String[] args) {
		// onOff handles state for turning on/off the calculator
		OnOff onOff = new OnOff();
		// toContinue handles state for whether the user wishes to continue or not
		ToContinue toContinue = new ToContinue();
		// checks for input from user and turns calculator on/off
		StateUtil.switchOnOff(onOff);
		// closes program if user selects off
		if(!onOff.status) {
			StateUtil.closeProgram(onOff);
		}
		// runs program if user selects on
		while(onOff.status) {
			toContinue.status = true;
			// runs calculator until user chooses to exit
			while(toContinue.status) {
				try {
					MathUtil.runCalculator(toContinue);
				// catches any errors if the user puts non-numeric values in place of the numbers
				} catch(NumberFormatException e) {
					System.out.println("You have entered a non-numeric value. Please only enter numeric values. If you need further assistance please enter HELP at any time.");
					StateUtil.switchToContinue(toContinue);
				}
			} 
			// closes program once user selected not to continue
			StateUtil.closeProgram(onOff);
		} 	
	}
}