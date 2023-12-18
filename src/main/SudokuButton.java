package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SudokuButton extends JButton {

	Font btnFont = new Font("Bahnschrift", Font.BOLD, 24);
	int number;
	int displayedNumber;
	boolean displayed;
	boolean isInputBtn;
	boolean highlighted;
	boolean locked;
	public SudokuButton(int number, boolean displayed, SudokuMouseListener ml, boolean locked)
	{
		this.setPreferredSize(50,50);
		this.setBackground(Color.WHITE);
		this.setFont(btnFont);
		this.number = number;
		this.addMouseListener(ml);
		this.displayed = displayed;
		this.setText(this.displayed ? Integer.toString(number) : "");
		this.locked = locked;
	}
	
	public void setDisplayedNumber(int displayNum) {
		if (this.locked) {return;}
		this.displayed = true;
		this.displayedNumber = displayNum;
		this.setText(Integer.toString(displayNum));
		setHighlighted(displayNum == this.number);
		
	}
	
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
		this.setBackground(highlighted ? Color.CYAN : Color.WHITE);
	}
	//Adding an overload because it's stupid that this isn't here already
	public void setPreferredSize(int width, int height)
	{
		this.setPreferredSize(new Dimension(width,height));
		
	}

}
