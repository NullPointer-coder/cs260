/*
 * @author Jingbo Wang
 *
 * A Test class for card;
 */

package edu.truman.cs260.jw6347.lab2;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

public class CardTest {

	@Test
	public void testRank() {
		// This test evaluates whether the
		// getRank function has been implemented correctly

		Card c = new Card("Queen", "Diamonds");
		int actual = c.getRank();
		int expected = 12;

		assertEquals(expected, actual);
	}

	@Test
	public void testRankString() {
		// This test evaluates whether the
		// getRankString function has been implemented correctly
		Card c = new Card("Queen", "Diamonds");
		String actual = c.getRankString();
		String expected = "Queen";

		assertEquals(expected, actual);
	}

	@Test
	public void testSuit() {
		// This test whetehr the getSuit function
		// is working as expected
		
		Card c = new Card("Queen", "Diamonds");
		String actual = c.getSuit();
		String expected = "Diamonds";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCompareNegative() {
		// create two Card objects with appropriate parameters
		Card c = new Card("Queen", "Diamonds");
		Card d = new Card("Queen", "Spades");
		
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is negative
		int actual = c.compareTo(d);
		int expected = -1;

		assertEquals(expected, actual);
	}

	@Test
	public void testComparePositive() {
		// create two Card objects with appropriate parameters
		Card c = new Card("Queen", "Diamonds");
		Card d = new Card("King", "Spades");
		
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is 1
		int actual = d.compareTo(c);
		int expected = 1;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testCompareInvalid() {
		// create two Card objects with appropriate parameters
		Card c = new Card("Queen", "Diamonds");
		Card d = new Card("Kin", "Spades");
		
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is 2
		int actual = d.compareTo(c);
		int expected = 2;

		assertEquals(expected, actual);
	}
	
	@Test
	public void testCompareEquals() {
		// create two Card objects with appropriate parameters
		Card c = new Card("King", "Spades");
		Card d = new Card(13, "Spades");
		
		// now test the two objects by using the compareTo function
		// compare the two objects in a way so that the
		// expected value is 2
		int actual = d.compareTo(c);
		int expected = 0;

		assertEquals(expected, actual);
	}

	@Test
	public void testPrintObjectName() {
		// create an object of the Card class with appropriate parameters
		Card c = new Card("10", "Diamonds");
		// test the toString function of the class
		String actual = c.toString();
		String expected = "10D";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPrintObjectInvalidCard() {
		// create an object of the Card class with invalid parameters
		Card c = new Card("34", "Diamonds");
		// test the toString function of the class.
		// Test to make sure that the toString function
		// returns "invalid card"
		String actual = c.toString();
		String expected = "invalid card";
		
		assertEquals(expected, actual);
	}


	@Test
	public void testJoker() {
		// create a joker card
		Card c = new Card("Joker", "None");
		// getSuit, getRank, getRankString
		String actual = c.getSuit() + " " + c.getRank() + " " + c.getRankString();
		String expected = "None 1 Joker";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCompareJoker() {
		// create a joker card 
		Card c = new Card("Joker", "None");
		// create another card 
		Card d = new Card(12, "Diamonds");
		// compareTo function by creating another object
		int actual = d.compareTo(c);
		int expected = -1;
		
		assertEquals(expected, actual);
	}
}