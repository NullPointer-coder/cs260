/*
 * Jingbo Wang
 */

package edu.truman.edu.cs260.jw6347.lab4;

public class Student 
{
	 private int st_id;
	 private String name;
	 
	 /*construct of Student*/
	 public Student(int id, String name)
	 {
	 this.st_id = id;
	 this.name = name;
	 }
	 
     /*getter of Student*/
	 int get_id() { return st_id; }
	 String get_name() { return name;} 
}
