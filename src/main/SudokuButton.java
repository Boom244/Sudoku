package main;

import java.awt.Button;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class SudokuButton extends Button {

	public SudokuButton()  {
		this.setPreferredSize(50,50);
	}
	
	//Adding an overload because it's stupid that this isn't here already
	public void setPreferredSize(int width, int height)
	{
		this.setPreferredSize(new Dimension(width,height));
	}

}
