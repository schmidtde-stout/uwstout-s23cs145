package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String IMAGE_PATH_FORMAT = "%s_of_%s.jpg";
    private List<PokerCard>  deck;
    private Hand playerHand;
    private PokerHandBox playerBox; 
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
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
			
		}
    	
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setAlignment(Pos.CENTER);

        HBox handBox = new HBox(10);
        handBox.setAlignment(Pos.CENTER);

        deck = createDeck();
        Collections.shuffle(deck);

        // Deal 5 cards to each player
        playerHand = new Hand();

        for (int i = 0; i < 5; i++) {
            playerHand.addCard(deck.remove(0));
        }

        // Create the player's hand UI
        playerBox = new PokerHandBox(playerHand, "Player");
        
        Button playAgainButton = new Button("Play Again?");
        
        // approach 1 - this::
        // playAgainButton.setOnAction(this::playAgainPressed);
        
        // approach 2 - design a class that implements the event handler interface
        // playAgainButton.setOnAction(new ButtonHandler());
        
        // approach 3 - create an anonymous inner class - "construct" an interface
        /*
        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
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
				
			}
        	
        });
        */
        
        // approach 4 - lambda expression (most popular)
        playAgainButton.setOnAction((e) -> {
	    	System.out.println("Re-dealing cards WITH LAMBDA....");
	    	
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
        });
        

        // Create the main layout
        VBox mainLayout = new VBox(20, playerBox, playAgainButton);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Poker Game");
        primaryStage.show();
    }
    

    private List<PokerCard> createDeck() {
        List<PokerCard> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new PokerCard(suit, rank));
            }
        }
        return deck;
    }
    
    /*
    public void playAgainPressed(ActionEvent event) {
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
    }
    */
    
}
