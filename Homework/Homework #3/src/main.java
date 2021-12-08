/*
 * Jingbo Wang 
 * To print out the list and find out the max String in the list
 */
import java.util.LinkedList;

import edu.truman.edu.cs260.jw6347.lab3.*;

public class main 
{

	public static void main(String[] args) 
	{
		// create a superTrio constructor
		superTrioClass superTrio = new superTrioClass("ABC", "DEF", "GHI");
		// print out the list
		System.out.println(superTrio.toList());
		// find out and print the max String 
		System.out.println("The max String:");
		System.out.println(superTrio.max());
	    
		System.out.println();
		// create a DoubleTrio constructor
		DoubleTrio doubleTrio = new DoubleTrio(1.23, 2.66, 1.15);
		// print out the lis
		System.out.println(doubleTrio.toList());
		// find out and print the max Double 
		System.out.println("The max Double:");
		System.out.println(doubleTrio.max());
        
		System.out.println();
		// create a IntegerTrio constructor
		IntegerTrio intergerTrio = new IntegerTrio(1, 2, 3);
		// print out the lis
		System.out.println(intergerTrio.toList());
		// find out and print the max Integer 
		System.out.println("The max integer:");
		System.out.println(intergerTrio.max());
		
		
		
	}
}
