package main;

/**
 * InputGridButton class
 * Inherits functionality from the SudokuButton class.
 */
public class InputGridButton extends SudokuButton { //this class only exists because the project insists on it. Oh well....
	
	
	/**
	 * Constructs an InputGridButton with the specified display number and GridButtonMouseListener.
	 * @param displayNumber The numeric value to be displayed on the button.
	 * @param ml The GridButtonMouseListener to handle mouse events for the button.
	 */
	public InputGridButton(int displayNumber, GridButtonMouseListener ml) {
		super(displayNumber,true,ml,true);
	}

}
