/*
 * Jingbo Wang 
 */
package edu.truman.edu.cs260.jw6347.lab3;

import java.util.Vector;

public class superTrioClass implements Trio<String>
{
  private String s1, s2, s3;
  
  /** Create a new object, initialized with the given values. */
  public superTrioClass(String s1, String s2, String s3) 
  {
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }
  
  @Override
  /** Take the values in the object and put them in a 
   *  new vecter list.
   *  @return the new list
  */
  public Vector<String> toList()
  {
    Vector<String> newList = new Vector<String>();
    newList.add(s1);
    newList.add(s2);
    newList.add(s3);
    return newList;
  }
  
  @Override
  /**
   *  Find and return the maximum of the three String and
   *  return it as an object.
   *  @return the max String
   */
  public String max()
  {
	if(s1.compareTo(s2) >= 0)
    {
      if(s1.compareTo(s3) >= 0)
      {
    	return s1;  
      }     
      else
      {
    	return s2;       
      }
    }
    else if(s2.compareTo(s3) >= 0)
    {
      return s2;
    }                
    return s3;
  }
}
