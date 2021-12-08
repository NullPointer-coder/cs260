/*
 * @author Jingbo Wang
 *
 * A class for creating card;
 */

package edu.truman.cs260.jw6347.lab2;

public class Card extends AbstractCard
{
  private final int  RANK_LENGTH = 16;
  private final int  SUIT_LENGTH = 5;
  private String rank;
  private String suit;
  private int rankNum;
  /**
   * creates a card with given rank and suit
   * @param rank a string rank of the card
   * @param suit a string suit of the card
   */
  public Card(String rank, String suit)   
  { 
	 this.rank = rank;
	 this.suit = suit;
	 // 2 -> 2, 3 -> 3, ..., 10 -> 10
	 // jack -> 11, queen -> 12, king -> 13, ace -> 14
	 if(this.rank != Card.RANKS[RANK_LENGTH - 1])
	 {
	   for (int i = 2; i < RANK_LENGTH - 1; i++)
	   {
	     if(this.rank == Card.RANKS[i])
	     {
	    	 rankNum = i;
	     }
	   }
	 }
	 // joker -> 1
	 else if (this.rank == Card.RANKS[RANK_LENGTH - 1])
	 {
		 rankNum = RANK_LENGTH - 15; 
	 }
	 else
	 {
		 // invalid card rank integer
		 rankNum = 0;
	 }
	 
	 if(getRank() > 1)
	 {
	   // rank must be a string found in Cards.RANKS
	   this.rank = Card.RANKS[getRank()];
	 }
	 // if getRank() = 1,return Jorker 
	 else if(getRank() == 1)
	 {
		this.rank = Card.RANKS[RANK_LENGTH - 1];
	 }
	 else
	 {
	   // invalid card rank name
	   this.rank = Card.RANKS[0];
	 }
	 
	 // card suit for non-Jorker
	  if (this.suit != Card.SUITS[SUIT_LENGTH - 1] && getRank() != 0)
	  {
	    for(int i = 0; i < SUIT_LENGTH - 1; i++)
	    { 
	      if (this.suit == Card.SUITS[i])
	  	  {
	    	this.suit = Card.SUITS[i];
	  	  }
	    } 
	  }
	  // invalid card suit or Jorker
	  else
	  {
		this.suit = Card.SUITS[SUIT_LENGTH - 1];
	  }
	  
	 toString();
   }
  
   /**
    * creates a card with the given rank and suit
    * @param rank a integer rank of the card
    * @param suit a string suit of the card
    */
   public Card(int rank, String suit)
   {
	 // suit must be a string found in Cards.SUITS
	 // 2 for 2, 3 for 3, .., 10 for 10
     // 11 for jack, 12 for queen, 13 for king, 14 for ace
	 if(rank == 1 || rank == 15)
	 {
	   this.rank = Card.RANKS[RANK_LENGTH - 1];
	 }
	 else if(rank > 1 && rank < 15)
	 {
	   this.rank = Card.RANKS[rank];
	 }
	 this.suit = suit;
	 
	 if(this.rank != Card.RANKS[RANK_LENGTH - 1])
	 {
	   for (int i = 2; i < RANK_LENGTH - 1; i++)
	   {
	     if(this.rank == Card.RANKS[i])
	     {
	    	 rankNum = i;
	     }
	   }
	 }
	 // joker -> 1
	 else if (this.rank == Card.RANKS[RANK_LENGTH - 1])
	 {
		 rankNum = RANK_LENGTH - 15; 
	 }
	 else
	 {
		 // invalid card rank integer
		 rankNum = 0;
	 }
	 
	 if(getRank() > 1)
	 {
	   // rank must be a string found in Cards.RANKS
	   this.rank = Card.RANKS[getRank()];
	 }
	 // if getRank() = 1,return Jorker 
	 else if(getRank() == 1)
	 {
		this.rank = Card.RANKS[RANK_LENGTH - 1];
	 }
	 else
	 {
	   // invalid card rank name
	   this.rank = Card.RANKS[0];
	 }
	 
	 // card suit for non-Jorker
	 if (this.suit != Card.SUITS[SUIT_LENGTH - 1] && getRank() != 0)
	 {
	   for(int i = 0; i < SUIT_LENGTH - 1; i++)
	   { 
	     if (this.suit == Card.SUITS[i])
	  	 {
	       this.suit = Card.SUITS[i];
	  	 }
	   } 
	 }
	 // invalid card suit or Jorker
	 else
	 {
	   this.suit = Card.SUITS[SUIT_LENGTH - 1];
	 }
	 
	 toString();
   }
   
   public int getRank()
   {
	 return rankNum;  
   }
   
   public String getRankString()
   { 
	 return rank;
   }
   
   public String getSuit()
   {
	  return suit;
   }
   
   	@Override
   	public int compareTo(AbstractCard otherObject) 
   	{
   	  int cardSuit = 0;
   	  int otherCardSuit = 0;
   	  Card other = (Card) otherObject;
   	  if(getRankString().equals(Card.RANKS[0]) || other.getRankString().equals(Card.RANKS[0]))
   	  {
   		  return 2;
   	  }
   	  else if(!(getRankString().isEmpty()) && !(other.getRankString().isEmpty()))
   	  {
   		for(int i = 0; i < SUIT_LENGTH - 1; i++)
  	    { 
  	      if (getSuit() == Card.SUITS[i])
  	  	  {
  	        cardSuit = i;
  	        break;
  	  	  }
  	    } 
     	for(int i = 0; i < SUIT_LENGTH - 1; i++)
  	    { 
  	      if (other.getSuit() == Card.SUITS[i])
  	  	  {
  	        otherCardSuit = i;
  	        break;
  	  	  }
  	    }  
     	if(getRank() == 1 && other.getRank() == 1)
     	{
     	  return 0; 
     	}
     	else
     	{
     	  if (getRank() == 1) { return 1; }
     	  if (other.getRank() == 1) { return -1; }
     	  if (getRank() < other.getRank()) { return -1; }
     	  if (getRank() > other.getRank()) { return 1; }
     	  if (getRank() == other.getRank()) 
     	  {
     		if (cardSuit < otherCardSuit) { return -1; }
       	    if (cardSuit > otherCardSuit) { return 1; }
     	  }
     	}   
   	  }  
   	  
   	  return 0;
   	}
}
