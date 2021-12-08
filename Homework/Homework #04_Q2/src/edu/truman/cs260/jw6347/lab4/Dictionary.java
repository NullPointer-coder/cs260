/*
 * Jingbo Wang
*/

package edu.truman.cs260.jw6347.lab4;
import java.io.*;
import java.util.*;

public class Dictionary 
{
	// words in the "dictionary.txt"
	public static Map<String, Integer> dictionary = new HashMap<>();
	// some words in the "words.txt" are not in the dictionary
	public static HashSet<String> WorngSpell = new HashSet<>();
	
	/**
	 * Check "words.txt" file whether it has words 
     * which are not in the dictionary
	 * @return a set of words which are not in the dictionary
	 * @throws FileNotFoundException
	 */
	public HashSet<String> CheckWordsFile() throws FileNotFoundException
	{
	  dictionary = readFile("dictionary.txt"); 
	  String fileName = "words.txt";
	  File inFile = new File(fileName);
	  Scanner wordsin = new Scanner(inFile);
	  int row = 1;
	  String result;
	  while(wordsin.hasNextLine())
	  {
	      String strLine = wordsin.nextLine();
		  String[] str = strLine.split(" ");
		  for(int col = 0; col < str.length; col++)
		  {
			str[col]  = delatePunct(str[col]);
			String tempStr = str[col].toLowerCase();
			if(!dictionary.containsKey(tempStr))
			{
			  result = str[col] + " " + row + " " + (col + 1);
			  WorngSpell.add(result);
			}
		  }	
		  row++;
	  }
	  wordsin.close();
	  return WorngSpell;
	}
	
	/**
	 * print out the result
	 */
	public void printResult() 
	{
		for (String object : WorngSpell)
		{
			System.out.println(object);
		}
	}
	
	/**
	 * read file to get into hashmap 
	 * @param FileName input file name
	 * @return a hashmap which including cleaned up words and their frequencies
	 * @throws FileNotFoundException
	 */
	public static Map<String, Integer> readFile(String FileName) throws FileNotFoundException
	{
		Map<String, Integer> tempMap = new HashMap<>();
		File inFile = new File(FileName);
		Scanner in = new Scanner(inFile);
		while(in.hasNextLine())
		{
			String tempstr = in.next();
			tempstr = delatePunct(tempstr);
			tempstr = tempstr.toLowerCase();
			tempMap.merge(tempstr, 1, (oldValue, value) -> oldValue + value);
		}
		in.close();
		return tempMap;
	}
	
	/**
	 * To delate punctuations
	 * @param str input string
	 * @return the input string without punctuations
	 */
	public static String delatePunct(String str)
	{
	  str = str.replaceAll("\\p{Punct}", "");
	  return str;
	} 
}
