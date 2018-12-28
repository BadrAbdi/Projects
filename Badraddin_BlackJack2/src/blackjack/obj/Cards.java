package blackjack.obj;


import java.util.TreeMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.Arrays;
import java.util.Random;

/*
 * Class for deck of cards 
 * used in the other files
 * 
 */
public class Cards{
  //treemap of the card and pair
 // pair is a class created to store value of a card and the amount left in the deck
  private TreeMap <Character,Pair> deck;
  //supresses rawtype warning of the arraylist
  @SuppressWarnings("rawtypes")
private ArrayList next;
  private String temp;
  Random rand = new Random();
  //supresswarnig for arraylist
  @SuppressWarnings("rawtypes")
public Cards(){
    deck = new TreeMap<Character,Pair>();
    next = new ArrayList();
    add();
   
   
  }
                
//supress unchecked warnings for the 
  @SuppressWarnings("unchecked")              
  public void add(){
   //creates deck with letter and amount and value
    deck.put('A',new Pair(4,11));
    deck.put('Q',new Pair(4,10));
    deck.put('K',new Pair(4,10));
    deck.put('J',new Pair(4,10));
    deck.put('2',new Pair(4,2));
    deck.put('3',new Pair(4,3));
    deck.put('4',new Pair(4,4));
    deck.put('5',new Pair(4,5));
    deck.put('6',new Pair(4,6));
    deck.put('7',new Pair(4,7));
    deck.put('8',new Pair(4,8));
    deck.put('9',new Pair(4,9));
    deck.put('0',new Pair(4,10));
   // System.out.println(deck.size());
    
    
    @SuppressWarnings("rawtypes")
 NavigableSet check = deck.navigableKeySet();
    @SuppressWarnings("rawtypes")
 Iterator itr = check.iterator();
    while(itr.hasNext()){
      next.add(itr.next());
    }
  }
  @SuppressWarnings("unchecked")
  public int hit(){
    while(true){
      @SuppressWarnings("rawtypes")
 NavigableSet check = deck.navigableKeySet();
      Iterator<Character> itr = check.iterator();
      int x = rand.nextInt(12);
      char ch =' ';
      for(int i =0;i<=x;i++){
        ch = itr.next();
      }
      if(deck.get(ch).amount > 0&& deck.get(ch).chars.size()>0){
        deck.get(ch).amount--;
        int k = rand.nextInt(deck.get(ch).chars.size()-1);
        temp = ch + " of " +deck.get(ch).chars.get(k);
        deck.get(ch).chars.remove(k);
        return deck.get(ch).value;
      }
      else continue;
    
    }
    //return -1;
  }
  //pair to store value and amount of a card
   class Pair{
    int amount;
    int value;
    ArrayList<Character> chars;
    Pair(int amount,int value){
      this.amount = amount;
      this.value = value;
       chars =new ArrayList<Character>(Arrays.asList('H','D','S','C'));
    }
  }
  //shows the card that hits
  public String showCard(){ return temp;}
 //getter for deck
  @SuppressWarnings("rawtypes")
public TreeMap getMap(){return deck;}
 
}