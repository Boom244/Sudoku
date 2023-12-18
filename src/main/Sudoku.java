package main;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Sudoku {

	
	 boolean[][] booleans = {
			{false, true, false, true, false, true,true, false, false},
			{false, false, false, true, false, true,true, true, true},
			{false, true, false, false, false, true,false, true, true},
			{false, false, true, false, true, false,false, false, true},
			{false, false, true, false, false, false,true, true, false},
			{true, true, true, false, false, true,true, true, false},
			{true, false, true, true, false, false,false, true, false},
			{true, true, false, true, false, true,false, true, true},
			{true, false, true, true, false, false,true, true, true},
	}; 
	
	 int[][] sudokuGrid = {
			{5,4,9,6,1,3,7,8,2},
			{8,3,1,2,5,7,9,6,4},
			{6,7,2,9,8,4,1,5,3},
			{4,1,5,3,7,8,2,9,6},
			{9,2,8,5,6,1,4,3,7},
			{7,6,3,4,2,9,5,1,8},
			{2,8,4,1,9,6,3,7,5},
			{1,5,7,8,3,2,6,4,9},
			{3,9,6,7,4,5,8,2,1}};
	 
	 SudokuButton[][] buttons;
	
	private int currentCaptiveInteger;
	private boolean gameWon;
	private JFrame holderPanel;
	
	public Sudoku()
	{
		holderPanel = new JFrame("Sudoku");
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		holderPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		holderPanel.setVisible(true);
		
		JPanel gamePanel = new JPanel();
		buttons = new SudokuButton[9][9];
		SudokuButton[] inputGridButtons = new SudokuButton[9];
		GridLayout gl = new GridLayout(3,3);
		holderPanel.add(gamePanel);
		gamePanel.setLayout(gl);
		SudokuMouseListener ml = new SudokuMouseListener(this);
		GridButtonMouseListener gbml = new GridButtonMouseListener(this);
		JPanel inputGridPanel = new JPanel();
		inputGridPanel.setLayout(gl);
		int squareRow, squareCol;
		int regionalX,regionalY;
		for (int i = 0; i < 9; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(gl);
			panel.setBorder(lineBorder);
			squareRow = (int) Math.floor(i / 3);
			squareCol = i % 3;
			
			for (int j = 0; j < 9; j++)
			{
				regionalX = squareRow*3 + ((int) Math.floor(j / 3));
				regionalY =  squareCol*3 + (j % 3);
				SudokuButton button = new SudokuButton(sudokuGrid[regionalX][regionalY], !booleans[regionalX][regionalY], ml,!booleans[regionalX][regionalY]);
				buttons[regionalX][regionalY] = button;
				panel.add(button);
			}
			gamePanel.add(panel);
			InputGridButton gridButton = new InputGridButton(i+1,gbml);
			inputGridPanel.add(gridButton);
			inputGridButtons[i] = gridButton;
		}
		holderPanel.add(gamePanel);
		holderPanel.add(inputGridPanel);
		holderPanel.setLayout(new GridLayout(1,2));
		holderPanel.pack();
		
		
	}
	
	public void setCurrentCaptiveInteger(int currentCaptiveInteger) {
		this.currentCaptiveInteger = currentCaptiveInteger;
	}
	
	public void verifyWin()
	{
		for (int i = 0; i < buttons.length; i++)
		{
			for (int j = 0; j < buttons[i].length; j++)
			{
				if (!buttons[i][j].locked && !buttons[i][j].highlighted) 
				{
					return;
				}
			}
		}

		gameWon = true;

		Thread winAnimation = new Thread(){
			
			public void run()
			{
				//If we aren't returned, the game's been won
				for (int i = 0; i < buttons.length; i++)
				{
					for (int j = 0; j < buttons[i].length; j++)
					{
						try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							buttons[i][j].setHighlighted(true);
							buttons[i][j].locked = true;
					}
				}
				holderPanel.setTitle("Game Over - You Win!");
			}	
		};
		winAnimation.start();
	}
	
	public boolean isGameWon() {
		return gameWon;
	}

	public int getCurrentCaptiveInteger() {
		return currentCaptiveInteger;
	}
	
	public static void main(String[] args) {
		new Sudoku(); //in theory no need to store it anywhere
	}
	
}
