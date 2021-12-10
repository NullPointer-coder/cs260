/*
 * Jingbo Wang
 */

import java.io.*;
import java.util.*;

public class BasicMaze
{
	final int SIZE = 2; 
	final int WEST = 1;
	final int SOUTH = 2;
	final int EAST = 3;
	final int NORTH = 4;
	int direction;
	int mazeRow;
	int mazeCol;
    
	char mazeGame[][];
	int exitedAdrees[] = new int[SIZE];
	int importantAdress[] = new int[SIZE];
	static Stack <int[]> markedDirection = new Stack<>();
	// constructor
	public BasicMaze(String fileName) throws FileNotFoundException
	{
		toArray(fileName);
		PlayMaze();
	}
	
	public char[][] mazeGameArray(char mazeGame[][])
	{
		mazeGame = new char[mazeRow][mazeCol];
		return mazeGame;
	}
	
	// next stap could go north or not
	public boolean goNorthTest(int[] currentAdress)
	{
		int row = currentAdress[0];
		int col = currentAdress[1];
		row -= 1;
		
		if(mazeGame[row][col] != '#')
		{
			direction = NORTH;
			return true;
		}
		return false;
	}
	
	// next stap could go east or not
	public boolean goEastTest(int[] currentAdress)
	{
		int row = currentAdress[0];
		int col = currentAdress[1];
		col += 1;
		
		if(mazeGame[row][col] != '#')
		{
		  direction = EAST;
		  return true;	
		}
		return false;
	}
	
	// next stap could go south or not
	public boolean goSouthTest(int[] currentAdress)
	{
		int row = currentAdress[0];
		int col = currentAdress[1];
		row += 1;
		
		if(mazeGame[row][col] != '#')
		{
			direction = SOUTH;
			return true;	
		}
		return false;
	}
	
	// next stap could go west or not
	public boolean goWestTest(int[] currentAdress)
	{
		int row = currentAdress[0];
		int col = currentAdress[1];
		col -= 1;
		
		if(mazeGame[row][col] != '#')
		{
			direction = WEST;
			return true;	
		}
		return false;
	}
    
	// go north
	public int[] goNorth(int[] currentAdress)
	{
		pirntOutAdress(currentAdress);
		if(!goEastTest(currentAdress)  && !goWestTest(currentAdress) && goNorthTest(currentAdress))
		{
			currentAdress[0] -= 1;
			return goNorth(currentAdress);
		}
//		if(goWestTest(currentAdress))
//		{
//			currentAdress[1] -= 1;
//			markedDirection.push(currentAdress);
//			return goWest(currentAdress);
//		}
//		if(goEastTest(currentAdress))
//		{
//			currentAdress[1] += 1;
//			markedDirection.push(currentAdress);
//			return goEast(currentAdress);
//		}
		return currentAdress;
	}
	
	// go east
	public int[] goEast(int[] currentAdress)
	{
		pirntOutAdress(currentAdress);
		if(!goNorthTest(currentAdress)  && !goSouthTest(currentAdress) && goEastTest(currentAdress))
		{
			currentAdress[1] += 1;
			return goEast(currentAdress);
		}
//		if(goSouthTest(currentAdress))
//		{
//			currentAdress[0] += 1;
//			markedDirection.push(currentAdress);
//			return goSouth(currentAdress);
//		}
//		if(goNorthTest(currentAdress))
//		{
//			currentAdress[0] -= 1;
//			markedDirection.push(currentAdress);
//			return goNorth(currentAdress);
//		}
		return currentAdress;
	}
	
	// go south
	public int[] goSouth(int[] currentAdress)
	{
		pirntOutAdress(currentAdress);
		if(!goEastTest(currentAdress)  && !goWestTest(currentAdress) && goSouthTest(currentAdress))
		{
			currentAdress[0] += 1;
			return goSouth(currentAdress);
		}
//		if(goWestTest(currentAdress))
//		{
//			currentAdress[1] -= 1;
//			markedDirection.push(currentAdress);
//			return goWest(currentAdress);
//		}
//		if(goEastTest(currentAdress))
//		{
//			currentAdress[1] += 1;
//			markedDirection.push(currentAdress);
//			return goEast(currentAdress);
//		}
		return currentAdress;
	}
	
	
	// go wast
	public int[] goWest(int[] currentAdress)
	{
		pirntOutAdress(currentAdress);
		if(!goNorthTest(currentAdress)  && !goSouthTest(currentAdress) && goWestTest(currentAdress))
		{
			currentAdress[1] -= 1;
			return goWest(currentAdress);
		}
//		if(goSouthTest(currentAdress))
//		{
//			currentAdress[0] += 1;
//			markedDirection.push(currentAdress);
//			return goSouth(currentAdress);
//		}
//		if(goNorthTest(currentAdress))
//		{
//			currentAdress[0] -= 1;
//			markedDirection.push(currentAdress);
//			return goNorth(currentAdress);
//		}
		return currentAdress;
	}
	
	public void findoutRoad(int[] currentAdress)
	{
		int[] temp =new int[2];
		if(goWestTest(currentAdress))
		{
			temp[0] =currentAdress[0];
			temp[1] =currentAdress[1] - 1;
			markedDirection.push(temp);
			goWest(temp);
		}
		if(goSouthTest(currentAdress))
		{
			temp[0] = currentAdress[0] + 1;
			temp[1] = currentAdress[1];
			markedDirection.push(temp);
			goSouth(temp);
		}
		if(goEastTest(currentAdress))
		{
			temp[0] = currentAdress[0];
			temp[1] = currentAdress[1] + 1;
			markedDirection.push(temp);
			goEast(temp);
		}
		if(goNorthTest(currentAdress))
		{
			temp[0] = currentAdress[0] - 1;
			temp[1] = currentAdress[1];
			markedDirection.push(temp);
			goNorth(temp);
		}
		
//		boolean done = false;
//		while(!done) 
//		{
//			if(goWestTest(currentAdress))
//			{
//				currentAdress[1] -=1;
//				markedDirection.push(currentAdress);
//				goWest(currentAdress);
//			}
//			if(goSouthTest(currentAdress))
//			{
//				currentAdress[0] += 1;
//				markedDirection.push(currentAdress);
//				goSouth(currentAdress);
//			}
//			if(goEastTest(currentAdress))
//			{
//				currentAdress[1] += 1;
//				goEast(currentAdress);
//			}
//			if(goNorthTest(currentAdress))
//			{
//				currentAdress[0] -= 1;
//				markedDirection.push(currentAdress);
//				goNorth(currentAdress);
//			}
//			if(mazeGame[currentAdress[0]][currentAdress[1]] 
//					== mazeGame[exitedAdrees[0]][exitedAdrees[1]])
//			{
//				done =true;
//			}
//		}
	}
	
	public void PlayMaze() 
	{
		foundStartedAdress();
		foundExitedAdress();
		if(Character.isAlphabetic(mazeGame[exitedAdrees[0]][exitedAdrees[1]]))
		{
			System.out.print(mazeGame[importantAdress[0]][importantAdress[1]]);
			findoutRoad(importantAdress);
		}
		else
		{
			System.out.println("Could not get out from the maze");
		}
		
		
	}
	
	/**
	 * read "maze.txt" file and store it into mazeGame array
	 * @throws FileNotFoundException
	 */
	public void toArray(String fileName) throws FileNotFoundException
    {
		 File inFile = new File(fileName);
		 Scanner in = new Scanner(inFile);
		 storeMazeGame(in);
		 in.close();
		 File secondInFile = new File(fileName);
		 Scanner secondIn = new Scanner(secondInFile);
		 ReadFile(secondIn);
		 secondIn.close();
    }
	
	// found start adress of the maze game 
	public void foundStartedAdress()
	{
		for(int row = 0; row < mazeRow; row++)
		{
			for(int col = 0; col < mazeCol; col++)
			{
				if(mazeGame[row][col] == '^')
				{
					importantAdress[0] =row;
					importantAdress[1] =col;
				}
			}
		}
	}
	public void pirntOutAdress(int[] currentAdress)
	{
	  if(Character.isAlphabetic((mazeGame[currentAdress[0]][currentAdress[1]])))
	  {
		System.out.print(" " + mazeGame[currentAdress[0]][currentAdress[1]]);
	  }
	}
	// found exit adress of the maze game 
		public void foundExitedAdress()
		{
			int row = 0;
			int col = 0;
			boolean result = false;
			// Check row 0
			for(col = 0; col < mazeCol; col++)
			{
				result = Character.isAlphabetic((mazeGame[row][col]));
				if(result)
				{
					exitedAdrees[0] =row;
					exitedAdrees[1] =col;
				}
			}
			
			// Check row 7
			row = mazeRow - 1;
			for(col = 0; col < mazeCol; col++)
			{
				result = Character.isAlphabetic((mazeGame[row][col]));
				if(result)
				{
					exitedAdrees[0] =row;
					exitedAdrees[1] =col;
				}
			}
			
			// Check col 0
			col = 0;
			for(row = 0; row < mazeCol; row++)
			{
				result = Character.isAlphabetic((mazeGame[row][col]));
				if(result)
				{
					exitedAdrees[0] =row;
					exitedAdrees[1] =col;
				}
			}
			
			// Check col 7
			col = mazeCol - 1;
			for(row = 0; row < mazeCol; row++)
			{
				result = Character.isAlphabetic((mazeGame[row][col]));
				if(result)
				{
					exitedAdrees[0] =row;
					exitedAdrees[1] =col;
				}
			}
		}
	
	
	/**
	 * initialize the size of maze game
	 * @param in initialize the Scanner format
	 */
	public void storeMazeGame(Scanner in)
	{
		int row = 0;
		String str = null;
		do
		{
		   str = in.nextLine();
		   row++;

		}while(in.hasNext());
		mazeCol = str.length();
		mazeRow = row;
		mazeGame = mazeGameArray(mazeGame);
		
	}
	
	// to store the maze in the board
	public void ReadFile(Scanner in)
	{
		int row = 0;
		while(in.hasNextLine())	    
		{
			String str = in.nextLine();
			for(int col = 0; col < mazeCol; col++)
			{
				mazeGame[row][col] = str.charAt(col);
			}
			row++;
	    }
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		@SuppressWarnings("unused")
		BasicMaze basicMaze = new BasicMaze("maze.txt");
	}
}