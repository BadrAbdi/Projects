package blackjack.obj;

///import blackjack.obj.Blackjack.Player;

public class Player{
	//player class
	public Cards card;
    public int score;
    public StringBuilder hand;
    public boolean deal;
    boolean play;
    public int first;
    public int money = 100;
    //constructor for player
    public Player(){
      score = 0;
      hand = new StringBuilder();
      play=true;
      card = new Cards();
      //hit();
      //hit();
      
    }
    /*constructor for dealer
     * uses cards from player
     */
    
    public Player(Cards card){
      deal = true;
      score = 0;
      hand = new StringBuilder();
      this.card= card ;
      //hit();
      //first =score;
      //hit();
    }
    //creates a new hand for new games
    //for dealer
    public void reset(Cards card){
    
        deal =true;
        score = 0;
        hand = new StringBuilder();
        this.card = card;
        //hit();
        //first =score;
        //hit();
      
      
    }
    //reset hand for new games
    //for player
    public void reset() {
    	score = 0;
        hand = new StringBuilder();
        play=true;
        card = new Cards();
        //hit();
        //hit();
    }
    //hits (takes card out of deck
    public void hit(){
    
      score+=card.hit();

      String c = (card.showCard().startsWith("0"))?card.showCard().replace("0","10") + " & ": card.showCard() + " & ";
      hand.append(c);
    }
    public void show(){
      if(!deal){
        System.out.print(score + " with: " +hand.toString() );
      }
      else{
        String[] str = hand.toString().split(" ");
        System.out.print(first + " with: X " +str[0]);
      }
    }
    //shows the hand
    public void show(Player dealer){
        System.out.print("Player: ");
        show();
        System.out.println();
        System.out.print("Dealer: ");
        dealer.show();
        System.out.println();
      }
    //shoes the hand of both players
    public String shows(Player dealer){
        return "Player: " + score + " with: " +hand.toString() + " Dealer: " +dealer.score + " with: " +dealer.hand.toString();
      }
    
    //find winner
    public String winner(Player dealer) {
    	 if(score == 21 && dealer.score == 21){
   	        return "Dealer";
   	       
   	      }
   	      else if(score == 21){
   	        return "Player";
   	      }
   	      else{
   	        if(score > 21){
   	          return "Dealer";
   	        }
   	        else if(dealer.score > 21){
   	          return "Player";
   	        }
   	        else{
   	          return dealer.score >= score?"Dealer":"Player";
   	          
   	        }
   	      }
    	
    }

    //adds or subtract money from bet
    public String winner(Player dealer,int bet) {
  	  if(score == 21 && dealer.score == 21){
  	        money-=bet;
  	        return "Dealer";
  	       
  	      }
  	      else if(score == 21){
  	        money+=bet;
  	        return "Player";
  	      }
  	      else{
  	        if(score > 21){
  	          money-=bet;
  	          return "Dealer";
  	        }
  	        else if(dealer.score > 21){
  	          money+=bet;
  	          return "Player";
  	        }
  	        else{
  	        	money = dealer.score >= score?money-bet:money+bet;
  	          return dealer.score >= score?"Dealer":"Player";
  	          
  	        }
  	      }
  	     
    }
    
  }
 
