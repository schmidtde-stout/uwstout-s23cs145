package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	// Variables for managing game state
	private List<PokerCard> deck;
	private Hand playerHand, computerHand;
	private PokerHandBox playerBox, computerBox;
	private int totalAmount = 1000;
	private int betAmount = 0;

	// UI components
	private Label totalLabel;
	private TextField betTextField;
	private Button betButton;
	private Label result;

	public static void main(String[] args) {
		launch(args);
	}

	// Method for dealing cards to the player and computer
	private void deal() {
		// Add all cards back to the deck and shuffle
		if (playerHand != null) {
			deck.addAll(playerHand.getCards());
			deck.addAll(computerHand.getCards());
		}
		Collections.shuffle(deck);

		// Deal cards to player and computer
		playerHand = new Hand();
		computerHand = new Hand();
		for (int i = 0; i < 5; i++) {
			playerHand.addCard(deck.remove(0));
			computerHand.addCard(deck.remove(0));
		}
	}

	// Method to create the game UI and set up the game logic
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(new Insets(15, 15, 15, 15));
		root.setAlignment(Pos.CENTER);

		HBox handBox = new HBox(10);
		handBox.setAlignment(Pos.CENTER);

		// Initialize the deck with all cards
		deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new PokerCard(suit, rank));
			}
		}

		// Setup each hand
		deal();
		playerBox = new PokerHandBox(playerHand, "Player", true);
		computerBox = new PokerHandBox(computerHand, "Computer", false);

		// Set up Play Again button logic
		Button playAgainButton = new Button("Play Again?");
		playAgainButton.setOnAction((e) -> {
			deal();
			playerBox.update(playerHand);
			computerBox.setReveal(false);
			computerBox.update(computerHand);
			betTextField.setText("0");
			betTextField.setDisable(false);
			betButton.setDisable(false);
			result.setText("");
		});

		// Set up UI components for betting
		totalLabel = new Label("" + totalAmount);
		betTextField = new TextField("" + betAmount);
		betTextField.setPrefWidth(50);
		betTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				betAmount = Integer.parseInt(newValue);
			} catch (NumberFormatException ex) {
				betTextField.setText("" + betAmount);
				
				// Add an alert that the user should only type integers
				Alert inputErrorAlert = new Alert(AlertType.ERROR);
				inputErrorAlert.setContentText("Only enter integer numbers for betting");
				inputErrorAlert.showAndWait();				
			}
		});
		betTextField.setVisible(false);
		
		// Set up Bet button logic
		betButton = new Button("Bet!");
		betButton.setOnAction((e) -> {
			
			TextInputDialog betInputDialog = new TextInputDialog();
			betInputDialog.setTitle(null);
			betInputDialog.setHeaderText(null);
			betInputDialog.setContentText("Enter your bet!");
			Optional<String> betString = betInputDialog.showAndWait();
			
			if(betString.isPresent()) {
				try {
					betAmount = Integer.parseInt(betString.get());
					computerBox.setReveal(true);
					computerBox.update(computerHand);
					if (playerHand.getScoreValue() > computerHand.getScoreValue()) {
						result.setText("You WON " + betAmount + "!");
						totalAmount += betAmount;
						betAmount = 0;
					} else if (playerHand.getScoreValue() < computerHand.getScoreValue()) {
						result.setText("You LOST " + betAmount + "!");
						totalAmount -= betAmount;
						betAmount = 0;
					} else {
						result.setText("You TIED!");
						betAmount = 0;
					}
					totalLabel.setText("" + totalAmount);
					betTextField.setDisable(true);
					betButton.setDisable(true);
				} catch (NumberFormatException ex) {
					betTextField.setText("" + betAmount);
					
					// Add an alert that the user should only type integers
					Alert inputErrorAlert = new Alert(AlertType.ERROR);
					inputErrorAlert.setContentText("Only enter integer numbers for betting");
					inputErrorAlert.showAndWait();				
				}			
				
			}
			
			
		});

		HBox playerControls = new HBox(5, new Label("Total"), totalLabel, betButton,
				playAgainButton);
		playerControls.setAlignment(Pos.CENTER);
		result = new Label("");

		// Create the main layout
		VBox mainLayout = new VBox(20, computerBox, playerBox, playerControls, result);
		mainLayout.setPadding(new Insets(20));
		mainLayout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Poker Game");
		primaryStage.show();
	}

}
