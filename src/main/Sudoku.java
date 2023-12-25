package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Sudoku game class. The holder for all the important variables and stuff needed to make the game run at its core.
 */
public class Sudoku {
		
	
	
	
	 /**
	 * Boolean 2D matrix that determines whether a button's number is invisible at runtime.
	 */
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
	
	
	 /**
	 * Integer 2D matrix of numbers to be assigned to buttons at runtime.
	 */
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
	
	 /**
	 * 2D Array of buttons to be accessed at runtime, particularly during the winning sequence
	 */
	SudokuButton[][] buttons; 
	
	/**
	 * Integer value of solves sitting between the player and winning.
	 * More resource-economical as opposed to checking manually every time a win needs verification.
	 */
	private int solvesUntilWin = 0; 
	
	/**
	 * The current captive integer of the class. This will be applied to blank buttons in the array upon clicking.
	 */
	private int currentCaptiveInteger = 1;
	
	/**
	 * The boolean that determines whether or not the game is won. Used to determine whether to sink input in an active game.
	 */
	private boolean gameWon;
	/**
	 * JFrame for the game process.
	 */
	private JFrame holderPanel;
	
	/**
	 * Constructor for the Sudoku class. Initializes frames and relevant arrays to be used during runtime. 
	 */
	public Sudoku()
	{
		holderPanel = new JFrame("Sudoku");
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		holderPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		holderPanel.setVisible(true);
		holderPanel.setResizable(false);
		JPanel gamePanel = new JPanel();
		buttons = new SudokuButton[9][9];
		InputGridButton[] inputGridButtons = new InputGridButton[9];
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
				SudokuButton button = new SudokuButton(sudokuGrid[regionalX][regionalY], !booleans[regionalX][regionalY], ml);
				buttons[regionalX][regionalY] = button;
				solvesUntilWin += (booleans[regionalX][regionalY] ? 1 : 0);
				panel.add(button);
			}
			gamePanel.add(panel);
			InputGridButton gridButton = new InputGridButton(i+1,gbml);
			inputGridPanel.add(gridButton);
			inputGridButtons[i] = gridButton;
		}
		
		inputGridPanel.setBorder(new EmptyBorder(50,50,50,50));
		holderPanel.add(gamePanel);
		holderPanel.add(inputGridPanel);
		holderPanel.setLayout(new GridLayout(1,2));
		holderPanel.pack();
		
		inputGridButtons[0].setHighlighted(true);
		gbml.captiveBtn = inputGridButtons[0];
		
		//pencil cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("src/resources/pencil_cursor.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(gamePanel.getX(), gamePanel.getY()), "img");
		gamePanel.setCursor(c);
		
		//icon
		holderPanel.setIconImage(toolkit.getImage("src/resources/icon.png"));
	}
	
	/**
	 * Setter function for currentCaptiveInteger.
	 */
	public void setCurrentCaptiveInteger(int currentCaptiveInteger) {
		this.currentCaptiveInteger = currentCaptiveInteger;
	}
	
	/**
	 * Solve increment/decrement function.
	 * @param increment the increment to add to solvesUntilWin. -1 backwards, 1 forwards.
	 */
	public void addSolves(int increment) {
		this.solvesUntilWin += increment;

	}
	
	/**
	 * Function called to verify whether the game has been won. Starts the win routine if the game has been won.
	 */
	public void verifyWin()
	{
		if (this.solvesUntilWin != 0) {return;}
		
		gameWon = true;

		new WinRoutine(this).start();
		holderPanel.setTitle("Game Over - You Win!");
	}
	
	/**
	 * Function for getting the boolean that determines whether or not the current game is won.
	 * @return whether or not the game is won.
	 */
	public boolean isGameWon() {
		return gameWon;
	}

	/**
	 * Tool for getting the game's current captive integer to assign to buttons.
	 * @return The game's current captive integer.
	 */
	public int getCurrentCaptiveInteger() {
		return currentCaptiveInteger;
	}
	
	/**
	 * Main class. Only one line put down, only one line needed.
	 */
	public static void main(String[] args) {
		new Sudoku(); //in theory no need to store it anywhere
	}
	
}
