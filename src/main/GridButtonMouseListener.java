package main;

import java.awt.event.MouseEvent;

public class GridButtonMouseListener extends SudokuMouseListener { //I will make your class but you can't make me enjoy it
		public GridButtonMouseListener(Sudoku game) {
			super(game);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
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
