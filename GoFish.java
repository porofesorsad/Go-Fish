/**
/*
 * Names:Antonio Alt and Yasmin Torres(The cooler one)
 * Period:2
 *
 * Go Fish Coding Assignment 
 * 
 * On my honor, by submitting this code I am claiming that it was written and tested by my group.  
 * Any help we received was in the form of asking questions for clarification and no direct copying was done.
 * 
 * The Go Fish game simulates a game of Go Fish between one player
 * and the computer. The goal of the game is to collect the most
 * pairs of cards. The computer and player alternate asking the other
 * for specific cards to make pairs. The game is over when the player or 
 * computer runs out of cards.
 */	
import java.util.ArrayList;
import java.util.Scanner;  

public class GoFish
   {
      public static void main (String [] args)
         {
            Scanner scan = new Scanner(System.in);           
            String [] suit = {"Diamond", "Heart", "Spade", "Club"};
            String [] rank = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Jack", "Queen", "King"};
            int [] point = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
            //Declares the deck, hands, and laydown piles
            Deck goFishDeck = new Deck(rank, suit, point);
            ArrayList<Card> pHand = new ArrayList<Card>();
            ArrayList<Card> cHand = new ArrayList<Card>();
            ArrayList<Card> pLaydown = new ArrayList<Card>();
            ArrayList<Card> cLaydown = new ArrayList<Card>();
            //Deals cards
            for (int i = 0; i<5; i++)
               {
                  pHand.add(goFishDeck.deal());
                  cHand.add(goFishDeck.deal());
               }
            //Checks for pairs
            for (int i = 0; i<cHand.size(); i++)
               {
               int d = 0;
                  for(int j = i+1; j<cHand.size();j++)
                     {

                        if(cHand.get(i).pointValue() == cHand.get(j).pointValue())
                           {
                                cLaydown.add(cHand.remove(j));
                                d++;
                           }
                     }
                  if(d>0)
                        cLaydown.add(cHand.remove(i));
               }
            for(int x=0; x<pHand.size();x++)
                 {
                  int d = 0;
                    for(int y=x+1; y<pHand.size(); y++)
                       {
                          if(pHand.get(x).pointValue() == pHand.get(y).pointValue())
                             {
                                pLaydown.add(pHand.remove(y));
                                d++;
                             }
                       }
                  if(d>0)
                  pLaydown.add(pHand.remove(x));
                 }
            //Round counter
            int c = 0;
            while ((pHand.size() > 0) && (cHand.size() > 0)){
               
                 // System.out.println(pHand);
                  //System.out.println(cHand);
                  c++;
                  System.out.println("Round " + c);
                  System.out.println(pHand);
                  
                  if (pHand.size()>0)
                  {
                  System.out.println("Player 1's turn ask for a card value.");
                  int reply = scan.nextInt();
 
                  int s = pHand.size();
                  for(int p = 0; p < cHand.size(); p++)
                     {
                           if(reply == cHand.get(p).pointValue())
                              pHand.add(cHand.remove(p));
                     }
                  if (s == pHand.size())
                     {
                        System.out.println("Go fish.");
                        pHand.add(goFishDeck.deal());
                     }
                    }
                  System.out.println(pHand);
                  //------------------------------------C O M P U T E R--------B E E P------B O O P---------------------------Yasmin-was-here-----------------------------------------------------------
                  int ran = (int)(Math.random()*cHand.size());
                  Card ranCard = cHand.get(ran);
                  if(cHand.size()>0)
                 {
                  System.out.println("Do you have a " + ranCard.pointValue()+ "? Say yes or go fish if you don't have it.");
                  String reply2 = scan.nextLine();
                  String reply3 = scan.nextLine();
                  if(reply3.equalsIgnoreCase("yes"))  
                     {
                     for(int i = 0; i < cHand.size(); i ++)
                        {
                       if(pHand.get(i).pointValue()==ranCard.pointValue())  
                       cHand.add(pHand.remove(i));
                         }
           
                    }
                  else if(reply3.equalsIgnoreCase("go fish"))
                   {
                    System.out.println("Go fish");
                    cHand.add(goFishDeck.deal());
                    }
                }    
                  for (int i = 0; i<cHand.size(); i++)
                      {
                  int d = 0;
                  for(int j = i+1; j<cHand.size();j++)
                     {

                        if(cHand.get(i).pointValue() == cHand.get(j).pointValue())
                           {
                                cLaydown.add(cHand.remove(j));
                                d++;
                           }
                     }
                  if(d>0)
                        cLaydown.add(cHand.remove(i));
               }
            for(int x=0; x<pHand.size();x++)
                 {
                  int d = 0;
                    for(int y=x+1; y<pHand.size(); y++)
                       {
                          if(pHand.get(x).pointValue() == pHand.get(y).pointValue())
                             {
                                pLaydown.add(pHand.remove(y));
                                d++;
                             }
                       }
                  if(d>0)
                  pLaydown.add(pHand.remove(x));
                 }
  
                    
               } 
 //---------------------------------------------E-N-D-G-A-M-E--------------------------------------------------------------------------------------------- 
            String theWorldChampionOfGoFish = "";
     
            if(cLaydown.size() > pLaydown.size())
            theWorldChampionOfGoFish = "Computer";
            
            else if( pLaydown.size() > cLaydown.size())
            theWorldChampionOfGoFish = "Human";
            
          else if(pLaydown.size() == cLaydown.size())
            System.out.println("*************It's tie!******");
          System.out.println(theWorldChampionOfGoFish);
         }
        
        
        }
		