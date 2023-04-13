package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage applicationStage) {
		Group root = new Group();
		Label label = new Label("HelloJavaFX");
		
		String imagePath = "five_of_hearts.jpg"; 
		Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(100);
		root.getChildren().add(imageView);
		root.getChildren().add(label);

		
		Scene scene = new Scene(root);
		applicationStage.setScene(scene);
		applicationStage.setTitle("HelloJavaFx"); // Set window's title
		applicationStage.show(); // Display window
	}

	public static void main(String[] args) {
		launch(args);
	}
}
