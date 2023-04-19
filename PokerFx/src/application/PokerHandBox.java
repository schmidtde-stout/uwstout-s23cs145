package application;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PokerHandBox extends VBox {
	
    private static final String IMAGE_PATH_FORMAT = "%s_of_%s.jpg";
    
	private Label nameLabel;
	private ArrayList<ImageView> cardImages;
	private Label scoreLabel;
	private boolean reveal;
	
	public PokerHandBox(Hand hand, String name, boolean reveal) {
		super(10);
		this.reveal = reveal;
		nameLabel = new Label("Player: " + name);
		scoreLabel = new Label(reveal ? "Score: " + hand.getScoreString() : "Place your bets!");
		cardImages = new ArrayList<ImageView>();
		
        HBox cardBox = new HBox(5);
        cardBox.setAlignment(Pos.CENTER);
        for (PokerCard card : hand.getCards()) {
            ImageView imageView = new ImageView(getImageForCard(card));
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            cardImages.add(imageView);
            cardBox.getChildren().add(imageView);
        }
        this.getChildren().add(nameLabel);
        this.getChildren().add(cardBox);
        this.getChildren().add(scoreLabel);
        this.setAlignment(Pos.CENTER);
    }
	
	public void setReveal(boolean reveal) {
		this.reveal = reveal;
	}
	
	private Image getImageForCard(PokerCard card) {
    	String imagePath = reveal ? String.format(IMAGE_PATH_FORMAT, card.getRank().name().toLowerCase(), card.getSuit().name().toLowerCase()) : "backofcard.jpg";
        return new Image(imagePath);		
	}
	
	public void update(Hand hand) {
		scoreLabel.setText(reveal ? "Score: " + hand.getScoreString() : "Place your bet!");
		int i = 0;
        for (PokerCard card : hand.getCards()) {
            ImageView imageView = cardImages.get(i);
            imageView.setImage(getImageForCard(card));
            i++;
        }
	}
	

}
