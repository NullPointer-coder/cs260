/*
 * To check "words.txt" file whether it has words 
 * which are not in the dictionary
 * Jingbo Wang
 */

import java.io.FileNotFoundException;
import edu.truman.cs260.jw6347.lab4.*;

public class SpellCheck 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
	  Dictionary dictionary = new Dictionary();
      // Check "words.txt" file whether it has words 
	  // which are not in the dictionary
	  dictionary.CheckWordsFile();
	  // print out the result of the spell checking
      dictionary.printResult();
	}
}
