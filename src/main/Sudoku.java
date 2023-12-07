package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Sudoku {

	
	static boolean[][] booleans = {
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
	
	static int[][] sudokuGrid = {
			{5,4,9,6,1,3,7,8,2},
			{8,3,1,2,5,7,9,6,4},
			{6,7,2,9,8,4,1,5,3},
			{4,1,5,3,7,8,2,9,6},
			{9,2,8,5,6,1,4,3,7},
			{7,6,3,4,2,9,5,1,8},
			{2,8,4,1,9,6,3,7,5},
			{1,5,7,8,3,2,6,4,9},
			{3,9,6,7,4,5,8,2,1}};
	
	public static void main(String[] args)
	{
		JFrame holderPanel = new JFrame("Sudoku");
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		holderPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		holderPanel.setVisible(true);
		JPanel gamePanel = new JPanel();
		GridLayout gl = new GridLayout(3,3);
		holderPanel.add(gamePanel);
		gamePanel.setLayout(gl);
		for (int i = 0; i < 9; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(gl);
			panel.setBorder(lineBorder);
			int[] ordered3x3 = getOrdered3x3(i);
			for (int j = 0; j < 9; j++)
			{
				SudokuButton button = new SudokuButton();
				button.setText(Integer.toString(ordered3x3[j]));
				panel.add(button);
			}
			gamePanel.add(panel);
		}
		holderPanel.add(gamePanel);
		holderPanel.pack();
		
		
	}
	/**
	 * Utility function for making arrays printable and viewable
	 * @param array the array you want to make printable
	 * @return a nice, space-separated String representation of an array with no brackets
	 */
	public static String sanitizeArray(int[] array, int index)
	{
		String[] arr = Arrays.toString(array).replaceAll("\\[|\\]|,", "").split("\\s+");
		
		for (int i = 0; i < arr.length; i++)
		{
			if (booleans[index][i])
			{
				arr[i] = "-";
			}
		}
		return String.join(" ", arr);
	}
	
	public static int[] getOrdered3x3(int panelOrder)
	{
		int[] ordered3x3 = new int[9];
		int row3x3 = (int)Math.floor(panelOrder / 3);
		int col3x3 = ((panelOrder - row3x3) % 3) * 3;
		int count = 0;
		for (int i = col3x3; i < col3x3 + 3; i++)
			for (int j = row3x3; j < row3x3 + 3; j++)
			{
				ordered3x3[count] = sudokuGrid[i][j];
				count++;
			}
		return ordered3x3;
	}
}
