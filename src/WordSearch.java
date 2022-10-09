/*
* AUTHOR: Ishika Patel
* FILE: WordSearch.java
* ASSIGNMENT: Programming Assignment 1 - Word Search
* COURSE: CSc 210; Section 001; Fall 2021
* PURPOSE: This program reads in 2 text files (a grid and a dictionary which
*  contain information about the words to search for in the word search and
*  the grid to find the words. There are 4 methods in addition to main. Each 
*  method searches for a particular word from top to bottom, bottom to top,
*  right to left, or left to right and prints them out. All words are printed
*  at the end of the program. 
*
* USAGE: 
* java WordSearch grid 
*
* grid.txt:
* -------------------------------------------
*|6
*|6
*|y c o d e j
*|h s e y p k
*|l p h b w a
*|l o b w x z
*|w o b a a i
*|p l y y c g
*| -------------------------------------------
*
** USAGE: 
* java WordSearch dictionary 
*
* dictionary.txt:
* -------------------------------------------
*|Aarhus
*|Aaron
*|Ababa
*|aback
*|abaft
*|abandon
*|abandoned
*|...
*| -------------------------------------------
*
* The commands shown above are all of the commands that are supported
* by this program. It is assumed that (except for some specific errors), 
* the input is well-formed, and matches the format shown above.
*/


import java.util.* ;
import java.io.* ;

public class WordSearch {
	public static void L2R (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method simply searches the word search grid from right
		 * to left and prints out any words found from the dictionary
		 * >= to length of 3. 
		 */
		String check = "";
		List<String> wordsfound = new ArrayList<String>();
		
		for (int r = 0; r < row; r++) 
		{
    		for (int c = 0; c < column; c++)
    		{
    			for (String word: dict) 
    			{
    	        	if (word.length() >= 3)
    	        	{
		    			if (grid [r][c] == word.charAt(0)) 
		    			{
		    				//iterates through all letters of word
		    				for (int i = 0; i < word.length(); i++)
		    				{
		    					if (c + i >= column)
		    						break;
		    					
		    					// checks to see if word from dictionary matches
		    					// word created from the grid 
		    					else if ((grid[r][c+i] == word.charAt(i))) 
		    					{
		    						check += word.charAt(i);
		    						if (check.equals(word)) 
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else
		    					{
		    						check = "";
		    						break; }
		    				}	
		    			}
    	        	}
    			}
    		}
		}
		for (int i = 0; i < wordsfound.size(); i++) 
		{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void R2L (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method simply searches the word search grid from left
		 * to right (backwards) and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		String check = "";
		List<String> wordsfound = new ArrayList<String>();
		
    	for (int r = 0; r < row; r++)
    	{
    		for (int c = column-1; c >= 0; c--)
    		{
    			for (String word: dict) 
    			{
    	        	if (word.length() >= 3)
    	        	{
		    			if (grid [r][c] == word.charAt(0))
		    			{
		    				//iterates through all letters of word
		    				for (int i = 0; i < word.length(); i++) 
		    				{
		    					if (c - i < 0) 
		    						break;
		    					
		    					// checks to see if word from dictionary matches
		    					// word created from the grid 
		    					else if ((grid[r][c-i] == word.charAt(i)))
		    					{
		    						check += word.charAt(i);
		    						if (check.equals(word)) 
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else 
		    					{
		    						check = "";
		    						break; }
		    				}	
		    			}
		    		}
		    	}
	    	}
    	}
	for (int i = 0; i < wordsfound.size(); i++) 
	{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void T2B (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid from top
		 * to bottom and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		String check = "";
				
    	for (int c = 0; c < column; c++)
    	{
    		for (int r = 0; r < row; r++) 
    		{
    			for (String word: dict)
    			{
    	        	if (word.length() >= 3) 
    	        	{
		    			for (int p = 0; p < word.length(); p++) 
		    			{
		    				// ensures program does not run out of bounds
		    				try 
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r+p][c] == word.charAt(p)) 
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word))
		    						{
		    							System.out.println(word);
		    							check = "";
		    							break; } }
		    					else 
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception) 
		    				{ break; }
		    			}
		    		}
		    	}
        	}
		}
	}
	
	public static void B2T (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid from bottom
		 * to top and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		String check = "";
		List<String> wordsfound = new ArrayList<String>();
		
		for (int c = 0; c < column ; c++) 
		{
    		for (int r = row-1; r >= 0; r--)
    		{
    			for (String word: dict)
    			{
    	        	if (word.length() >= 3)
    	        	{
		    			for (int p = 0; p < word.length(); p++) 
		    			{
		    				// ensures program does not run out of bounds
		    				try 
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r-p][c] == word.charAt(p)) 
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word))
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else 
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception)
		    				{ break; }
		    			}
		    		}
		    	}
        	}
		}
		for (int i = 0; i < wordsfound.size(); i++) 
		{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void south_east (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid diagonally from top
		 * left to bottom right and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		List<String> wordsfound = new ArrayList<String>();
		String check = "";
		
		for (int r = 0; r < row; r++) 
		{
    		for (int c = 0; c < column; c++)
    		{
    			for (String word: dict) 
    			{
    	        	if (word.length() >= 3)
    	        	{
    	        		for (int p = 0; p < word.length(); p++) 
    	        		{
    	        			// ensures program does not run out of bounds
		    				try 
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r+p][c+p] == word.charAt(p)) 
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word)) 
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception)
		    				{ break; }
    	        		}
    	        	}
    			}
    		}
		}
		for (int i = 0; i < wordsfound.size(); i++) 
		{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void north_west (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid diagonally from bottom
		 * right to top left and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */	
		List<String> wordsfound = new ArrayList<String>();
		String check = "";
		
		for (int r = row; r >= 0; r--) 
		{
    		for (int c = column-1; c >= 0; c--) 
    		{
    			for (String word: dict)
    			{
    	        	if (word.length() >= 3)
    	        	{
    	        		for (int p = 0; p < word.length(); p++)
    	        		{
    	        			// ensures program does not run out of bounds
		    				try 
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r-p][c-p] == word.charAt(p))
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word)) 
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception) 
		    				{ break; }
    	        		}
    	        	}
    			}
    		}	
		}
		for (int i = 0; i < wordsfound.size(); i++) 
		{ System.out.println(wordsfound.get(i)); }
	}

	public static void north_east (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid diagonally from bottom
		 * left to top right and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		List<String> wordsfound = new ArrayList<String>();
		String check = "";
		
		for (int r = row; r >= 0; r--) 
		{
    		for (int c = 0; c < column; c++) 
    		{
    			for (String word: dict) 
    			{
    	        	if (word.length() >= 3)
    	        	{
    	        		for (int p = 0; p < word.length(); p++) 
    	        		{
    	        			// ensures program does not run out of bounds
		    				try
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r-p][c+p] == word.charAt(p))
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word))
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else 
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception) 
		    				{ break; }
    	        		}
    	        	}
    			}
    		}
		}
		for (int i = 0; i < wordsfound.size(); i++) 
		{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void south_west (int row, int column, List<String> dict, char[][] grid)
	{
		/* This method searches the word search grid diagonally from top
		 * right to bottom left and prints out any words found from 
		 * the dictionary >= to length of 3. 
		 */
		List<String> wordsfound = new ArrayList<String>();
		String check = "";
		
		for (int r = 0; r < column; r++) 
		{
    		for (int c = column; c >= 0; c--) 
    		{
    			for (String word: dict) 
    			{
    	        	if (word.length() >= 3)
    	        	{
    	        		for (int p = 0; p < word.length(); p++) 
    	        		{
    	        			// ensures program does not run out of bounds
		    				try 
		    				{
		    					// checks to see if word from dictionary matches
		    					// word created from the grid
		    					if (grid[r+p][c-p] == word.charAt(p))
		    					{
		    						check += word.charAt(p);
		    						if (check.equals(word)) 
		    						{
		    							wordsfound.add(word);
		    							check = "";
		    							break; } }
		    					else 
		    					{
		    						check = "";
		    						break; } }
		    				catch (IndexOutOfBoundsException exception)
		    				{ break; }
    	        		}
    	        	}
    			}
    		}
		}
		for (int i = 0; i < wordsfound.size(); i++)
		{ System.out.println(wordsfound.get(i)); }
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//try to open dictionary.txt file
		Scanner dictfile = null;
		try { dictfile = new Scanner (new File(args[0])); }
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		//try to open grid.txt file
		Scanner gridfile = null;
		try { gridfile = new Scanner(new File(args[1])); }
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		// creates array of words from dictionary file
		List<String> dict = new ArrayList<String>();
		while (dictfile.hasNext()) {
        	dict.add(dictfile.nextLine().trim().toLowerCase()); }
		dictfile.close();

		int row = Integer.valueOf(gridfile.nextLine());
		int column = Integer.valueOf(gridfile.nextLine());
		char [][] grid = new char[row][column];
		
		//creates grid from grid file
		for (int x = 0; x < row; x++) {
			String line = gridfile.nextLine();
			String [] parts = line.split(" ");
			for (int y = 0; y < column; y++) {
				grid[x][y] = parts[y].toLowerCase().charAt(0);}}	
		gridfile.close();
		
    	L2R (row, column, dict, grid);
    	R2L (row, column, dict, grid);
    	T2B (row, column, dict, grid);
    	B2T(row, column, dict, grid);
    	/*south_east (row, column, dict, grid);
    	north_west (row, column, dict, grid);
    	north_east (row, column, dict, grid);
    	south_west (row, column, dict, grid);*/
	}
}