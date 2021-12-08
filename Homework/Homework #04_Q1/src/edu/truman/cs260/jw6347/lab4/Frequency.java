/*
 * Jingbo Wang
 */
package edu.truman.cs260.jw6347.lab4;

import java.io.*;
import java.util.*;

public class Frequency 
{
	// A hash map to store the words and teir frequencies
	public static Map<String, Integer> map = new HashMap<>();
	
	/**
	 * calculate the frequency of the words in the "words.txt" file
	 * @return A hash map to store the words and teir frequencies
	 * @throws FileNotFoundException 
	 */
	public Map<String, Integer> toMapList() throws FileNotFoundException
    {
	  String fileName = "words.txt";
	  File inFile = new File(fileName);
	  Scanner in = new Scanner(inFile);
	  ReadFile(in);
	  in.close();
	  return map;
	}
	
	/**
	 * clean up the format of the words
	 * and put one string and its frequency in to map
	 * @param in initialize the Scanner format
	 */
	public void ReadFile(Scanner in)
	{
	  while(in.hasNext())
	  {
	    String str = in.next();
		str = str.toLowerCase();
		str = delatePunct(str);
		map.merge(str, 1, (oldValue, value) -> oldValue + value);
	  }
	}
	
	/**
	 * To delate punctuations
	 * @param str input string
	 * @return the input string without punctuations
	 */
	public String delatePunct(String str)
	{
	  str = str.replaceAll("\\p{Punct}", "");
	  return str;
	}
	
	/**
	 * print the result of the words and their frequencies
	 */
	public void printResult() 
	{
	  Set<String> keySet = map.keySet();
	  for (String key : keySet)
	  {
	    Integer value = map.get(key);
	    System.out.println(key + " " + value);
	  }
	}
}
