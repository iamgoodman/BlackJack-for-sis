
import java.util.Scanner; 



public class Blackjack {
    
    public static void main(String[] args) {
    
       int Usermoney;         
       int Userbet;           
       boolean userWins;   
       
       System.out.println("Welcome to Sadies black Jack Game");
       System.out.println();
       
       Usermoney = 100;  
    
       while (true) {
    	   System.out.println("You Currently have " + Usermoney + " dollars.");
           do {
        	   System.out.println("Your bet is?  (Enter 0 to end.)");
        	   Scanner scanner1 = new Scanner(System.in);
        	    Userbet = scanner1.nextInt();
             
              if (Userbet < 0 || Userbet > Usermoney)
            	  System.out.println("Your answer must be between 0 and " + Usermoney + '.');
           } while (Userbet < 0 || Userbet > Usermoney);
           if (Userbet == 0)
              break;
           userWins = playBlackjack();
           if (userWins)
              Usermoney = Usermoney + Userbet;
           else
              Usermoney = Usermoney - Userbet;
          
           if (Usermoney == 0) {
        	   System.out.println("You have lost all your money ");
              break;
           }
       }
       
      
       System.out.println("You leave the game with $" + Usermoney + '.');
    
    } 
    
    static boolean playBlackjack() {
       
       Deck deck;                  
       BlackjackHand dealerHand;   
       BlackjackHand userHand;     
       
       deck = new Deck();
       dealerHand = new BlackjackHand();
       userHand = new BlackjackHand();
 

       
       deck.shufflecards();
       dealerHand.addCard( deck.dealCard() );
       dealerHand.addCard( deck.dealCard() );
       userHand.addCard( deck.dealCard() );
       userHand.addCard( deck.dealCard() );
       


       
       if (dealerHand.getBlackjackValue() == 21) {
    	   System.out.println("Sadie the Dealer has the " + dealerHand.getCard(0)
                                    + " and the " + dealerHand.getCard(1) + ".");
    	   System.out.println("you have the " + userHand.getCard(0)
                                      + " and the " + userHand.getCard(1) + ".");
       
    	   System.out.println("Sadie the Dealer has Blackjack.  Sadie wins.");
            return false;
       }
       
       if (userHand.getBlackjackValue() == 21) {
    	   System.out.println("Sadie the Dealer has the " + dealerHand.getCard(0)
                                    + " and the " + dealerHand.getCard(1) + ".");
    	   System.out.println("You have  the " + userHand.getCard(0)
                                      + " and the " + userHand.getCard(1) + ".");
          
    	   System.out.println("You have Blackjack.  You win.");
            return true;
       }
       
  
       
       while (true) {
           
          
 
        
           System.out.println("Your cards are:");
            for ( int i = 0; i < userHand.getCardCount(); i++ )
                System.out.println("    " + userHand.getCard(i));
            System.out.println("Your total is " + userHand.getBlackjackValue());
            System.out.println();
            System.out.println("Sadie the dealer is showing the " + dealerHand.getCard(0));
            System.out.println();
            System.out.println("Hit (H) or Stand (S)? ");
           char entered;  // User's response, 'H' or 'S'.
            do {
            	Scanner scanner = new Scanner(System.in);
             
               entered= scanner.findInLine(".").charAt(0);
            	
             
               if (entered != 'H' && entered != 'S')
                   System.out.println("Please respond H or S:  ");
            } while (entered != 'H' && entered != 'S');
 
           
 
            if ( entered == 'S' ) {
                 
                break;
            }
            else {  
                Card newCard = deck.dealCard();
                userHand.addCard(newCard);
               
                System.out.println("User hits.");
                System.out.println("Your card is the " + newCard);
                System.out.println("Your total is now " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {
                    
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the " 
                                                       + dealerHand.getCard(1));
                    return false;  
                }
            }
            
       } 
       
    
 
       System.out.println();
       System.out.println("User stands.");
       System.out.println("Sadie Dealer's cards are");
       System.out.println("    " + dealerHand.getCard(0));
       System.out.println("    " + dealerHand.getCard(1));
       while (dealerHand.getBlackjackValue() <= 16) {
          Card newCard = deck.dealCard();
          System.out.println("Sadie the Dealer hits and gets the " + newCard);
          dealerHand.addCard(newCard);
          if (dealerHand.getBlackjackValue() > 21) {
              System.out.println();
             System.out.println("Sadie the Dealer busted by going over 21.  You win.");
             return true;
          }
       }
       System.out.println("Sadie the Dealer's total is " + dealerHand.getBlackjackValue());
       

       System.out.println();
       if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
           System.out.println("Sadie the Dealer wins on a tie.  You lose.");
          return false;
       }
       else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
           System.out.println("Sadie the Dealer wins, " + dealerHand.getBlackjackValue() 
                           + " points to " + userHand.getBlackjackValue() + ".");
          return false;
       }
       else {
           System.out.println("You win, " + userHand.getBlackjackValue() 
                           + " points to " + dealerHand.getBlackjackValue() + ".");
          return true;
       }
 
    }  
 
 
 } 