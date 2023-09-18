import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class InvestmentCalculator extends Application {
    // Textboxes and button used in the GUI
    private TextField investmentBx = new TextField();
    private TextField yearsBx = new TextField();
    private TextField interestRateBx = new TextField();
    private TextField valueBx = new TextField();
    private Button calculateBtn = new Button("Calculate");

    public void start(Stage primaryStage) {
        // separates the inputs using GridPane
        GridPane gridPane = new GridPane();
        // sets vertical and horizontal gaps between the boxes
        gridPane.setHgap(4);
        gridPane.setVgap(4);
        // Labels and input boxes are organized on the GUI
        gridPane.add(new Label("Investment Amount:"), 0, 0);
        gridPane.add(investmentBx, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(yearsBx, 1, 1);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(interestRateBx, 1, 2);
        gridPane.add(new Label("Future Value:"), 0, 3);
        gridPane.add(valueBx, 1, 3);
        gridPane.add(calculateBtn, 1, 4);

        // Aligns the input boxes
        gridPane.setAlignment(Pos.CENTER);
        investmentBx.setAlignment(Pos.BOTTOM_RIGHT);
        yearsBx.setAlignment(Pos.BOTTOM_RIGHT);
        interestRateBx.setAlignment(Pos.BOTTOM_RIGHT);
        valueBx.setAlignment(Pos.BOTTOM_RIGHT);
        valueBx.setEditable(false);
        GridPane.setHalignment(calculateBtn, HPos.RIGHT);

        // Assigns the button to the calculate method
        calculateBtn.setOnAction(e -> calculate());

        // Shows the GUI
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Investment Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Used to calculate the interest
    private void calculate() {
        // Converts all textbox input as doubles
        double investment = Double.parseDouble(investmentBx.getText());
        double years = Double.parseDouble(yearsBx.getText());
        double interest = Double.parseDouble(interestRateBx.getText());
        // Calculates the base value
        double a = ((interest / 12) / 100) + 1;
        // Calculates the exponent value
        double b = years * 12;
        // Calculate final output value
        double value = investment * Math.pow(a, b);
        // Sets the outputbox to 2 floating decimals
        valueBx.setText(String.format("$%.2f", value));
    }

    public static void main(String[] args) {
        launch(args);
    }
}