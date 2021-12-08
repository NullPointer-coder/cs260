import edu.truman.cs260.jw6347.lab2.*;

/*
 * @author Jingbo Wang
 *
 * A class to compare two cards;
 */

public class CardCompare 
{
	private static final String NULL = null;
	public static String max(Card a, Card b)
	{ 
		if (a.compareTo(b) == 1) 
		{ 
			if(!(a.getRankString().equals("Joker")))
			{
				return ("\"" + a.getRankString() +  " " + a.getSuit() +"\""
					    + " is bigger than " + "\"" + b.getRankString() + " "+ b.getSuit() + "\"."); 
			}
			return ("\"" + a.getRankString() +"\""
				    + " is bigger than " + "\"" + b.getRankString() + " "+ b.getSuit() + "\"."); 
		}
		else if (a.compareTo(b) == -1) 
		{ 
			if(!(b.getRankString().equals("Joker")))
			{
				return ("\"" + a.getRankString() + " " + a.getSuit() + "\"" 
						+ " is less than " + "\"" + b.getRankString() + " "+ b.getSuit() + "\"."); 
			}
			return ("\"" + a.getRankString() + " " + a.getSuit() + "\"" 
					+ " is less than " + "\"" + b.getRankString() + "\"."); 
		}
		else if (a.compareTo(b) == 2)
		{
			return ("There is at least one invalid card.");
		}
		return "They are same.";
	}
	public static void main(String[] args) 
	{
        int capcompareResult = 0; 	
        String result = NULL;
        
        System.out.println("(Queen, Diamonds)");
		Card c = new Card("Queen","Diamonds");
		System.out.println("getRankString() = " + c.getRankString());
		System.out.println("getRank() = " + c.getRank());
		System.out.println("getSuit() = " + c.getSuit());
		System.out.println(c);
		
		System.out.println();
		
		System.out.println("(12, Spades)");
		Card d = new Card(12,"Spades");
		System.out.println("getRankString() = " + d.getRankString());
		System.out.println("getRank() = " + d.getRank());
		System.out.println("getSuit() = " + d.getSuit());
		System.out.println(d);
		
		System.out.println();
		
		System.out.println("(Queen, Diamonds) compareTo (12, Spades)");
		capcompareResult = c.compareTo(d);
		System.out.println(capcompareResult);
		result= max(c,d);
		System.out.println("result:");
		System.out.println(result);
		
		System.out.println();
		
		System.out.println("(12, Spades) compareTo (Queen, Diamonds)");
		capcompareResult = d.compareTo(c);
		System.out.println(capcompareResult);
		System.out.println("result:");
		result=max(d,c);
		System.out.println(result);
		
		System.out.println();
		
		System.out.println("(Jack,Spades)");
		Card e = new Card("Jack","Spades");
		System.out.println("getRankString() = " + e.getRankString());
		System.out.println("getRank() = " + e.getRank());
		System.out.println("getSuit() = " + e.getSuit());
		System.out.println(e);
		
		System.out.println();
		
		System.out.println("(1,None)");
		Card j = new Card(1,"None");
		System.out.println("getRankString() = " + j.getRankString());
		System.out.println("getRank() = " + j.getRank());
		System.out.println("getSuit() = " + j.getSuit());
		System.out.println(j);
		
		System.out.println();
		
		System.out.println("(Jack,Spades) compareTo (1,None)");
		capcompareResult = e.compareTo(j);
		System.out.println(capcompareResult);
		System.out.println("result:");
		result=max(e,j);
		System.out.println(result);
		
		System.out.println();
		
		System.out.println("(17,Spades)");
		Card J = new Card(17,"Spades");
		System.out.println("getRankString() = " + J.getRankString());
		System.out.println("getRank() = " + J.getRank());
		System.out.println("getSuit() = " + J.getSuit());
		System.out.println(J);
		
		System.out.println();
		
		System.out.println("(17,Spades) compareTo (1,None)");
		capcompareResult = J.compareTo(j);
		System.out.println(capcompareResult);
		System.out.println("result:");
		result=max(J,j);
		System.out.println(result);
	}
}
