/*
 * Jingbo Wang
 * This is a interface trio
 */
package edu.truman.edu.cs260.jw6347.lab3;

import java.util.List;

interface Trio<T> 
{
  public List<T> toList();
  public T max();
}
