package main;

import java.util.Arrays;

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
		
		
		
		for (int i = 0; i < sudokuGrid.length; i++)
		{
			System.out.println(sanitizeArray(sudokuGrid[i],i));
		}
		
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
}
