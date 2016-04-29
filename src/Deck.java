

public class Deck {

    private Card[] deck;   
    private int UsedCardCounter; 
    
    public Deck() {
          
       deck = new Card[52];
       int cardcounter = 0; 
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck[cardcounter] = new Card(value,suit);
             cardcounter++;
          }
       }
       UsedCardCounter = 0;
    }
    
    public void shufflecards() {
      
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        UsedCardCounter = 0;
    }
    
    public int RemainingCard() {
    
        return 52 - UsedCardCounter;
    }
    
    public Card dealCard() {
          
        if (UsedCardCounter == 52)
           shufflecards();
        UsedCardCounter++;
        return deck[UsedCardCounter - 1];
    }

}