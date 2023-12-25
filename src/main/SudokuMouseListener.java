package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * MouseListener implementation for handling mouse events on Sudoku buttons.
 * Extends the MouseListener interface.
 */
public class SudokuMouseListener implements MouseListener {
	
	/**
	 * The Sudoku instance required for this MouseListener to access game features.
	 */
	Sudoku game;
	
	
	
	/**
	 * Constructs SudokuMouseListener with reference to the Sudoku game.
	 * @param game The Sudoku game associated with the listener.
	 */
	public SudokuMouseListener(Sudoku game) {
		this.game = game;
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}
	
	/**
	 * Invoked when the mouse button is pressed on a SudokuButton.
	 * Handles the mouse click event by setting the displayed number on the button,
	 * updating the game's solves count, and verifying if the game is won.
	 *
	 * @param e The MouseEvent object containing information about the event.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		SudokuButton btn = (SudokuButton)e.getSource();
		if (!btn.locked)
		{
			int winLoseIncrement = btn.setDisplayedNumber(game.getCurrentCaptiveInteger());
			game.addSolves(winLoseIncrement);
			game.verifyWin();
		}	

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
