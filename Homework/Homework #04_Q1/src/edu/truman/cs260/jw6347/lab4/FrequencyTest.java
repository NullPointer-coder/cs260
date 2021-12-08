/*
 * Jingbo Wang
 */

package edu.truman.cs260.jw6347.lab4;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import org.junit.*;

public class FrequencyTest 
{
	/**
	 * Test the result of words frequency is correct or not
	 * @throws FileNotFoundException
	 */
	@Test
	public void FileWordsFrequencyTest() throws FileNotFoundException 
	{
		Frequency frequency = new Frequency();
		Map<String, Integer> actual = frequency.toMapList();
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("can",6);
		expected.put("a",3);
		expected.put("canner",1);
		expected.put("as",1);
		expected.put("you",1);
		assertEquals(expected, actual);
	}
}
