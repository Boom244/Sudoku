package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;


/**
 * Button class for a Sudoku game, extending JButton class.
 */
public class SudokuButton extends JButton {
	
	/**
	 * Default button font.
	 */
	static Font btnFont = new Font("Bahnschrift", Font.BOLD, 24);
	/**
	 * The <b>true</b> number value of the button.
	 */
	int number;
	/**
	 * The <b>displayed</b> number value of the button. May or may not hold parity with the true number value.
	 */
	int displayedNumber;
	/**
	 * Boolean determining whether any number is displayed on the button.
	 */
	boolean displayed;
	/**
	 * Boolean determining whether the button is highlighted.
	 */
	boolean highlighted;
	/**
	 * Boolean determining whether the button can have its number value changed.
	 */
	boolean locked;
	Color selectionColor = new Color(120, 154, 204);
	
	/**
	 * SudokuButton constructor.
	 *
	 * @param number The number value associated with the button.
	 * @param displayed Boolean indicating whether the number should be displayed on the button.
	 * @param ml SudokuMouseListener to handle mouse events for the button.
	 * @param locked Boolean indicating whether the button is locked.
	 */
	public SudokuButton(int number, boolean displayed, SudokuMouseListener ml)
	{
		this.setPreferredSize(50,50);
		this.setBackground(Color.WHITE);
		this.setFont(btnFont);
		this.number = number;
		this.addMouseListener(ml);
		this.displayed = displayed;
		this.setFocusPainted(false); //Gets rid of the dumb rectangle around the text when selected
		this.setText(this.displayed ? Integer.toString(number) : "");
		this.locked = displayed;
		if (locked)
		{
			this.setForeground(new Color(60,105,209));
		}
	}
	
	/**
	 * Sets the displayed number on the SudokuButton, updating its visual representation.
	 * @param displayNum The new number to be displayed on the button.
	 * @return 0 if the button is locked; 1 if the displayed number was different and has been changed;
	 *         -1 if the displayed number was the same as the input and has been reset.
	 */
	public int setDisplayedNumber(int displayNum) {
		if (this.locked) {return 0;}
		int returnValue = 0;
		if (this.number == this.displayedNumber && displayNum != this.number)
		{
			returnValue = 1;
		} else if (this.number == displayNum && this.displayedNumber != this.number)
		{
			returnValue = -1;
		}
		this.displayed = true;
		this.displayedNumber = displayNum;
		this.setText(Integer.toString(displayNum));
		setHighlighted(displayNum == this.number);
		return returnValue;
	}
	
	/**
	 * Sets the highlighted state of the SudokuButton, updating its visual appearance.
	 * @param highlighted true to highlight the button, false to remove highlighting.
	 */
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
		this.setBackground(highlighted ? selectionColor : Color.WHITE);
	}
	
	public void setHighlighted(Color customColor)
	{
		this.highlighted = true;
		this.setBackground(customColor);
	}
	
	/**
	 * Sets the preferred size of the SudokuButton using the specified width and height.
	 * Overrides the existing preferred size and updates the button's dimensions accordingly.
	 *
	 * @param width The new width for the preferred size.
	 * @param height The new height for the preferred size.
	 */
	public void setPreferredSize(int width, int height)
	{
		this.setPreferredSize(new Dimension(width,height));
		
	}

}
