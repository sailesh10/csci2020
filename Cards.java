import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Cards extends Application {

  @Override //override start method
	public void start(Stage primaryStage) {

		ArrayList<Integer> cards = getCards(); //list of number of cards
		HBox pane = new HBox(5); //horizontal pane
		pane.setPadding(new Insets(5, 5, 5, 5));

		for (int i = 0; i < 3; i++) { //nodes in pane
			pane.getChildren().add(new ImageView(new Image("Assignment1/Cards" +
				cards.get(i) + ".png"))); //getting the images
		}

		Scene scene = new Scene(pane); //creates a scene in stage
		primaryStage.setTitle("Cards"); // Set stage title
		primaryStage.setScene(scene); // Place the scene in stage
		primaryStage.show(); // Displays the stage
	}

	private ArrayList<Integer> getCards() {  //returns list with card numbers 1-52 randomly
		ArrayList<Integer> cards = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			cards.add(i + 1);
		}
		java.util.Collections.shuffle(cards); //shuffles the cards so they get displayed randomly
		return cards;
	}
}
