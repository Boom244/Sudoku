package main;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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
	 
	 int currentCaptiveInteger;
	
	public Sudoku()
	{
		JFrame holderPanel = new JFrame("Sudoku");
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		holderPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		holderPanel.setVisible(true);
		
		JPanel gamePanel = new JPanel();
		SudokuButton[][] buttons = new SudokuButton[9][9];
		SudokuButton[] inputGridButtons = new SudokuButton[9];
		GridLayout gl = new GridLayout(3,3);
		holderPanel.add(gamePanel);
		gamePanel.setLayout(gl);
		SudokuMouseListener ml = new SudokuMouseListener(this);
		JPanel inputGridPanel = new JPanel();
		inputGridPanel.setLayout(gl);
		int squareRow, squareCol;
		for (int i = 0; i < 9; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(gl);
			panel.setBorder(lineBorder);
			squareRow = (int) Math.floor(i / 3);
			squareCol = i % 3;
			int[] ordered3x3 = getOrdered3x3(i,squareRow,squareCol);
			for (int j = 0; j < 9; j++)
			{
				SudokuButton button = new SudokuButton(ordered3x3[j], ordered3x3[j] != 0, ml, false,ordered3x3[j] != 0);
				buttons[squareRow*3 + ((int) Math.floor(i / 3))][squareCol*3 + (i % 3)] = button;
				panel.add(button);
			}
			gamePanel.add(panel);
			SudokuButton inputGridButton = new SudokuButton(i+1,true,ml,true,true);
			inputGridPanel.add(inputGridButton);
			inputGridButtons[i] = inputGridButton;
		}
		holderPanel.add(gamePanel);
		holderPanel.add(inputGridPanel);
		holderPanel.setLayout(new GridLayout(1,2));
		holderPanel.pack();
		
		
	}
	
	public void setCurrentCaptiveInteger(int currentCaptiveInteger) {
		this.currentCaptiveInteger = currentCaptiveInteger;
	}
	
	public int getCurrentCaptiveInteger() {
		return currentCaptiveInteger;
	}
	
	public static void main(String[] args) {
		Sudoku game = new Sudoku();
	}
	
	public int[] getOrdered3x3(int panelOrder,int squareRow,int squareCol)
	{
		int[] ordered3x3 = new int[9];
		int regionalX, regionalY;
		for (int i = 0; i < 9; i++)
		{					   
			regionalX = (squareRow * 3) + ((int) Math.floor(i / 3)); //square row * 3 + inner row calculation,
			regionalY = (squareCol*3) + (i % 3); //square col * 3 + inner col calculation
			ordered3x3[i] = !booleans[regionalX][regionalY] ? sudokuGrid[regionalX][regionalY] : 0;
		}
		return ordered3x3;
	}
}
