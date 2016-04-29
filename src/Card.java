
public class Card {

    public final static int SPADES = 0,       
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
                            
    public final static int ACE = 1,         
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    private final int suit;   
                              
    private final int value;  
                             
    public Card(int var, int sui) {
            
        value = var;
        suit = sui;
    }
        
    public int getSuit() {
          
        return suit;
    }
    
    public int getValue() {
            
        return value;
    }
    
    public String SuittoString() {
            
    	
    	if(suit == SPADES)
    		return "Spades";
    	else if (suit == HEARTS)
    		return "Hearts";
    	else if (suit == DIAMONDS)
    		return "Diamonds";
    	else if (suit == CLUBS)
    		return "Clubs";
    	else 
    		return "invalid";
      
    }
    
    public String ValuetoString() {
            
    	if(value == 1)
    		return "Ace";
    	else if (value == 2)
    		return "2";
    	else if (value == 3)
    		return "3";
    	else if (value == 4)
    		return "4";
    	else if (value == 5)
    		return "5";
    	else if (value == 6)
    		return "6";
    	else if (value == 7)
    		return "7";
    	else if (value == 8)
    		return "8";
    	else if (value == 9)
    		return "9";
    	else if (value == 10)
    		return "10";
    	else if (value == 11)
    		return "Jack";
    	else if (value == 12)
    		return "Queen";
    	else if (value == 13)
    		return "King";
    	else return "invalid";
    	
   
    }
    
    public String toString() {
        
        return ValuetoString() + " of " + SuittoString();
    }


} 