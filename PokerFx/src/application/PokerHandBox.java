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
	
	public PokerHandBox(Hand hand, String name) {
		super(10);
		nameLabel = new Label("Player: " + name);
		scoreLabel = new Label("Score: " + hand.getScoreString());
		cardImages = new ArrayList<ImageView>();
		
        HBox cardBox = new HBox(5);
        cardBox.setAlignment(Pos.CENTER);
        for (PokerCard card : hand.getCards()) {
            String imagePath = String.format(IMAGE_PATH_FORMAT, card.getRank().name().toLowerCase(), card.getSuit().name().toLowerCase());
            Image image = new Image(imagePath);
            ImageView imageView = new ImageView(image);
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
	
	public void update(Hand hand) {
		scoreLabel.setText("Score: " + hand.getScoreString());
		int i = 0;
        for (PokerCard card : hand.getCards()) {
            String imagePath = String.format(IMAGE_PATH_FORMAT, card.getRank().name().toLowerCase(), card.getSuit().name().toLowerCase());
            Image image = new Image(imagePath);
            ImageView imageView = cardImages.get(i);
            imageView.setImage(image);
            i++;
        }
	}
	

}
