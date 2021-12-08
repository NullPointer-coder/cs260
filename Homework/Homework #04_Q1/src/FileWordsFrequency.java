/*
 * To calculate the frequency of the words in the file 
 * and print out the Result
 * Jingbo Wang
 */

import java.io.*;
import edu.truman.cs260.jw6347.lab4.*;

public class FileWordsFrequency 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
	  Frequency frequency = new Frequency();
	  // calculate the frequency of the words in the file
	  frequency.toMapList();
	  // print out the result
      frequency.printResult();
	}

}
