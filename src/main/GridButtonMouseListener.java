package main;

import java.awt.event.MouseEvent;

/**
 * Mouse listener for grid buttons. 
 * Inherits from SudokuMouseListener so I don't have to explicitly override all the functions of interface MouseListener again.
 */
public class GridButtonMouseListener extends SudokuMouseListener { 
		
	/**
	 * Captive button to have its highlighted status changed later on.
	 */
		InputGridButton captiveBtn;
		
		
		/**
		 * Constructor for GridButtonMouseListener.
		 * @param game The Sudoku game that this GridButtonMouseListener was instantiated in.
		 */
		public GridButtonMouseListener(Sudoku game) {
			super(game);
		}
		
		/**
		 * Handles the mouse press event for the InputGridButton.
		 * @param e The MouseEvent object containing information about the event.
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			if (this.game.isGameWon()) {return;}
			InputGridButton btn = (InputGridButton)e.getSource();
			this.game.setCurrentCaptiveInteger(btn.number);
			if (captiveBtn != null)
			{
				captiveBtn.setHighlighted(false);
			}
				btn.setHighlighted(true);
				captiveBtn = btn;
			}
			
}
