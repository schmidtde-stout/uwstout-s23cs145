package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {

    private static final String IMAGE_PATH_FORMAT = "%s_of_%s.jpg";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setAlignment(Pos.CENTER);

        HBox handBox = new HBox(10);
        handBox.setAlignment(Pos.CENTER);

        List<PokerCard> deck = createDeck();
        Collections.shuffle(deck);

        // Deal 5 cards to each player
        Hand playerHand = new Hand();

        for (int i = 0; i < 5; i++) {
            playerHand.addCard(deck.remove(0));
        }

        // Create the player's hand UI
        VBox playerBox = createHandUI(playerHand, "Player");

        // Create the main layout
        VBox mainLayout = new VBox(20, playerBox);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Poker Game");
        primaryStage.show();
    }
    
    private VBox createHandUI(Hand hand, String playerName) {
        HBox cardBox = new HBox(5);
        cardBox.setAlignment(Pos.CENTER);

        for (PokerCard card : hand.getCards()) {
            String imagePath = String.format(IMAGE_PATH_FORMAT, card.getRank().name().toLowerCase(), card.getSuit().name().toLowerCase());
            Image image = new Image(imagePath);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            cardBox.getChildren().add(imageView);
        }

        Label nameLabel = new Label(playerName);
        Label scoreLabel = new Label("Score: " + hand.getScoreString());

        VBox handBox = new VBox(10, nameLabel, cardBox, scoreLabel);
        handBox.setAlignment(Pos.CENTER);
        return handBox;
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
}
