package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SudokuButton extends JButton {

	Font btnFont = new Font("Bahnschrift", Font.BOLD, 24);
	int number;
	boolean displayed;
	public SudokuButton(int number, boolean displayed, SudokuMouseListener ml)  {
		this.setPreferredSize(50,50);
		this.setBackground(Color.WHITE);
		this.setFont(btnFont);
		this.number = number;
		this.addMouseListener(ml);
		this.displayed = displayed;
		this.setText(this.displayed ? Integer.toString(number) : "");
	}
	
	//Adding an overload because it's stupid that this isn't here already
	public void setPreferredSize(int width, int height)
	{
		this.setPreferredSize(new Dimension(width,height));
		
	}

}
