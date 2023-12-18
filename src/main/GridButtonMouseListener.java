package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GridButtonMouseListener extends SudokuMouseListener implements MouseListener { //I will make your class but you can't make me enjoy it
		public GridButtonMouseListener(Sudoku game) {
			super(game);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
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
