package application;


import javafx.event.EventHandler;

import java.util.Collections;

import javafx.event.ActionEvent;

public class ButtonHandlerNonInner implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		/* 
		 * As a non-inner class, I can't access instance variables (playerHand, etc.)
		 * 
    	System.out.println("Re-dealing cards....");
    	
    	for(PokerCard card : playerHand.getCards()) {
    		deck.add(card);
    	}
    	
        Collections.shuffle(deck);

        // Deal 5 cards to each player
        playerHand = new Hand();

        for (int i = 0; i < 5; i++) {
            playerHand.addCard(deck.remove(0));
        }    
        
        playerBox.update(playerHand);
	*/	
	}
}
