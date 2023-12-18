package main;

@SuppressWarnings("serial") //shhhh
public class InputGridButton extends SudokuButton { //this class only exists because the project insists on it. Oh well....
	
	public InputGridButton(int displayNumber, GridButtonMouseListener ml) {
		super(displayNumber,true,ml,true);
	}

}
