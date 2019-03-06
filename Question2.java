import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Question2 extends Application {
	private TextField tfInvestmentAmount = new TextField(); //textfields to enter values
	private TextField tfYears = new TextField();
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfFutureValue = new TextField();
	private Button btCalculate = new Button("Calculate"); //button that initiates calculation

	@Override // override start method
	public void start(Stage primaryStage) {
		// Creates the User Interface
		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(new Label("Investment Amount:"), 0, 0);
		pane.add(tfInvestmentAmount, 1, 0);
		pane.add(new Label("Years:"), 0, 1);
		pane.add(tfYears, 1, 1);
		pane.add(new Label("Annual Interest Rate:"), 0, 2);
		pane.add(tfAnnualInterestRate, 1, 2);
		pane.add(new Label("Future value:"), 0, 3);
		pane.add(tfFutureValue, 1, 3);
		pane.add(btCalculate, 1, 4);

		// Setting up the User Interface properties
		pane.setAlignment(Pos.CENTER);
		tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfYears.setAlignment(Pos.BOTTOM_RIGHT);
		tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setEditable(false);
		pane.setHalignment(btCalculate, HPos.RIGHT);
		pane.setPadding(new Insets(10, 10, 10, 10));

		btCalculate.setOnAction(e -> futureValue());

		// Creates a scene in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Investment Value Calculator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void futureValue() {
		double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
		int years = Integer.parseInt(tfYears.getText());
		double monthlyInterestRate =
			Double.parseDouble(tfAnnualInterestRate.getText()) / 1200;
		tfFutureValue.setText(String.format("$%.2f",
			(investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12))));
	}
}
