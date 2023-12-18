package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuMouseListener implements MouseListener {

	Sudoku game;
	SudokuButton captiveBtn;
	public SudokuMouseListener(Sudoku game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SudokuButton btn = (SudokuButton)e.getSource();
		if (!btn.locked)
		{
			btn.setDisplayedNumber(this.game.getCurrentCaptiveInteger());
			game.verifyWin();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
