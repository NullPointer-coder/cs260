/*
 * Jingbo Wang
 */
package edu.truman.edu.cs260.jw6347.lab3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class TrioTest 
{
	@Test
	public void superTrioClasstoListTest() 
	{
		// Creat a superTrio
		superTrioClass superTrio = new superTrioClass("ABC", "DEF", "GHI");
		// actual = superTrio.toList()
		Vector<String> actual = superTrio.toList();
		Vector<String> expected = new Vector<String>();
        // add same elements
		expected.add("ABC");
        expected.add("DEF");
        expected.add("GHI");
        // bool them are same
		assertEquals(expected, actual);
	}
	
	@Test
	public void superTrioClassmaxTest() 
	{
		// Creat a superTrio
		superTrioClass superTrio = new superTrioClass("ABC", "DEF", "GHI");
		// find out the max String and give to actual
		String actual = superTrio.max();
		// expected is the true max String
		String expected = "GHI";
		// bool them are same
		assertEquals(expected, actual);
	}
	
	@Test
	public void DoubleTriotoListTest() 
	{
		// actual = DoubleTrio.toList()
		DoubleTrio doubleTrio = new DoubleTrio(1.23, 2.66, 1.15);
		LinkedList<Double> actual = doubleTrio.toList();
		LinkedList<Double> expected = new  LinkedList<Double>();
        // add same elements
		expected.add(1.23);
        expected.add(2.66);
        expected.add(1.15);
        // bool them are same
		assertEquals(expected, actual);
	}
	
	@Test
	public void DoubleTriomaxTest() 
	{
		// Creat a double trio
		DoubleTrio doubleTrio = new DoubleTrio(1.23, 2.66, 1.15);
		// find out the max String and give to actual
		Double actual = doubleTrio.max();
		// expected is the true max String
		Double expected = 2.66;
		// bool them are same
		assertEquals(expected, actual);
	}
	
	@Test
	public void IntegerTriotoListTest() 
	{
		// actual = DoubleTrio.toList()
		IntegerTrio integerTrio = new IntegerTrio(1, 2, 3);
		ArrayList<Integer> actual = integerTrio.toList();
		ArrayList<Integer> expected = new ArrayList<Integer>();
        // add same elements
		expected.add(1);
        expected.add(2);
        expected.add(3);
        // bool them are same
		assertEquals(expected, actual);
	}
	
	@Test
	public void IntegerTriomaxTest() 
	{
		// Creat a double trio
		IntegerTrio integerTrio = new IntegerTrio(1, 2, 3);
		// find out the max String and give to actual
		Integer actual = integerTrio.max();
		// expected is the true max String
		Integer expected = 3;
		// bool them are same
		assertEquals(expected, actual);
	}
}
