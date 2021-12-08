/*
 * To campare the same name and id in the evenlines and the oddlines.
 * Jingbo Wang
 */
import java.io.*;
import java.util.*;

import edu.truman.edu.cs260.jw6347.lab4.*;
public class StudentIdFilter 
{
	public static void main(String[] args) throws IOException 
	{
		  SetOperation set = new SetOperation();
		  // read student name and id in the "student.txt"
		  // and store in the "oddlines.txt" and "evenlines.txt"
		  set.readStudentsFile();
		  // to get the same name and id in the evenlines and the oddlines
		  set.campareSame();
		  // print out the result
		  set.printResult();
	}

}
