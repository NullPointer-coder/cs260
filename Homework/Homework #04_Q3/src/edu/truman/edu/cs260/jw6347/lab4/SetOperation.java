/*
 * Jingbo Wang
 */

package edu.truman.edu.cs260.jw6347.lab4;

import java.io.*;
import java.util.*;

public class SetOperation 
{
	// a hashset stores evenline students information  
	public static Set<Student> evenSet = new HashSet<>();
	// a hashset stores oddline students information
	public static Set<Student> oddSet = new HashSet<>();
	// a hashset stores same students information
	public static Set<Student> sameSet = new HashSet<>();
	
	/**
	 *  read "stduens.txt" file 
	 *  to store evenline students into evenSet
	 *  and store oddline students into oddSet
	 *  @throws IOException
	 */
	public void readStudentsFile() throws IOException
	{
	  String fileName = "students.txt";
	  File inFile = new File(fileName);
	  Scanner in = new Scanner(inFile);
	  PrintWriter outEeven = new PrintWriter("evenlines.txt");
	  PrintWriter outOdd = new PrintWriter("oddlines.txt");
      int row = 0;
      while(in.hasNextLine())
	  {
		String str = in.nextLine();
        String[] spliteStrings = str.split(" ");
        final int len = spliteStrings.length; 
        String name = spliteStrings[len - 1];
        int id = Integer.parseInt(spliteStrings[0]);
        if(row % 2 == 0)
        {
          outEeven.println(id + " " + name); 
        }
        else
        {
          outOdd.println(id + " " + name); 
	    }
        row++;
	  }
      outOdd.close();
      outEeven.close();
      in.close();
	}
	
	/**
	 * compute evenSet and oddSet to get the student informations
	 * @throws FileNotFoundException
	 */
	public Set<Student> campareSame() throws FileNotFoundException
	{
		evenSet = readFile("evenlines.txt");
		oddSet = readFile("oddlines.txt");
		for(Student evenLine: evenSet)
		{
			for(Student oddLine : oddSet)
			{
			    if (evenLine.get_name().equals(oddLine.get_name()) && evenLine.get_id() == oddLine.get_id())
			    {
				    sameSet.add(new Student(evenLine.get_id(), evenLine.get_name()));
			    }
			}
		}
		return sameSet;
	}
	
	/**
	 * print out the result
	 */
	public void printResult() 
	{
		for (Student object : sameSet)
		{
			System.out.println(object.get_id() + " " + object.get_name());
		}
	}
	
	
	/**
	 * read file to get into a hashset 
	 * @param FileName input file name
	 * @return a hashset which including Student object 
	 *         which contains student id and name 
	 * @throws FileNotFoundException
	 */
	public static Set<Student> readFile(String FileName) throws FileNotFoundException
	{
		Set<Student> words = new HashSet<>();
		File inFile = new File(FileName);
		Scanner in = new Scanner(inFile);
		while(in.hasNextLine())
		{
			String str = in.nextLine();
			str = delatePunct(str);
			int id = 0;
			String name = null;
	        for (int index = 0; index < str.length(); index++)
	        {
	        	if(str.charAt(index) == ' ')
	        	{
	        		id = Integer.parseInt(str.substring(0,index));
	        		name = str.substring(index + 1, str.length());
	        	}
	        }
			words.add(new Student(id, name));
		}
		in.close();
		return words;
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
