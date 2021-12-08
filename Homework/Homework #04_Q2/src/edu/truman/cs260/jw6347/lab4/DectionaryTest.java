/*
 * Jingbo Wang
 */

package edu.truman.cs260.jw6347.lab4;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import org.junit.*;

public class DectionaryTest 
{
  /**
   * To check WorngSpell is correct or not
   * @throws FileNotFoundException
   */
  @Test 
  public void WorngSpelltest() throws FileNotFoundException
  {
	  Dictionary dictionary = new Dictionary();
      HashSet<String> actual = new HashSet<>();
      actual = dictionary.CheckWordsFile();
      HashSet<String> expected = new HashSet<>();
      expected.add("names 2 2");
      expected.add("Drake 2 7");
      expected.add("Hunter 2 8");
      expected.add("bling 1 8");
      assertEquals(expected, actual);
  }
}
