package main;

import java.awt.Color;

/**
 * Threaded routine animation for winning the game.
 */
public class WinRoutine extends Thread {
	/**
	 * The instance of the current Sudoku game.
	 */
	Sudoku game;
	/**
	 * Constructor.
	 * @param game The instance of the current Sudoku game.
	 */
	public WinRoutine(Sudoku game){
		this.game = game;
	}
	
	/**
	 * Thread functionality. Changes colors of all Sudoku buttons to gold.
	 */
	@Override
	public void run()
	{
		Color customColor = new Color(255, 215, 0);
		//If we aren't returned, the game's been won
		for (SudokuButton[] row: game.buttons)
		{
			for (SudokuButton button:row)
			{
				if (!button.highlighted)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					button.setHighlighted(customColor);
					button.locked = true;
			}
		}
	}
}
