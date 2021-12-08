package edu.truman.edu.cs260.jw6347.lab3;
/*
 * Jingbo Wang
 */
import java.util.LinkedList;

public class DoubleTrio implements Trio<Double>
{
 private double d1, d2, d3;
 
 /** Create a new object, initialized with the given values. */
 public DoubleTrio (double alpha, double beta, double gamma)
 {
   d1 = alpha;
   d2 = beta;
   d3 = gamma;
 }

 /** Take the values in the object and put them in a list.
 @return the new list
 */
 public LinkedList<Double> toList()
 {
   LinkedList<Double> dll = new LinkedList<Double>();
   dll.add(d1);
   dll.add(d2);
   dll.add(d3);
   return dll;
 }

 /** Find and return the maximum of the three doubles, as a
 wrapper.
 @return the maximum, wrapped
 */
 public Double max()
 {
   if (d1 >= d2) 
   {
     if (d1 >= d3) 
     {
       return d1;
     }
   } 
   else if (d2 >= d3) 
   {
     return d2;
   }
   return d3;
 }

}
