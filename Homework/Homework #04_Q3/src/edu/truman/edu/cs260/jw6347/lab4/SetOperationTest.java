/*
 * Jingbo Wang
 */

package edu.truman.edu.cs260.jw6347.lab4;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import org.junit.*;
public class SetOperationTest 
{
	/**
	 * to check same student information is correct or not
	 * @throws FileNotFoundException
	 */
	@Test 
	public void SameSettest() throws FileNotFoundException
	{
		SetOperation set = new SetOperation();
		Set<Student> actualSet = new HashSet<>();
		actualSet = set.campareSame();
	    Set<Student> expectedSet = new HashSet<>();
	    expectedSet.add(new Student(10, "Sabiha"));
	    expectedSet.add(new Student(5, "John"));
	    int actual = 0;
	    int expected = 2;
	    for (Student exp : expectedSet)
		{
	    	for (Student act : actualSet)
			{
	    		if(exp.get_name().equals(act.get_name()) 
	    		   && exp.get_id() == act.get_id())
	    		{
	    			actual++;                               
	    		}
			}
		}
	    assertEquals(expected, actual);
	}
 
}
