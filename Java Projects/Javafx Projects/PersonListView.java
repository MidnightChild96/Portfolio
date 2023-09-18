import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.stage.*;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PersonListView extends Application {
    // used to display text
    TextArea textDisplay;
    // Array used for an example list
    private Person[] personArray = { new Person("Ian", "Bergstrom"), new Person("Carter", "Daniel"),
            new Person("March", "Hill") };

    public void start(Stage primaryStage) {
        // sets text area box size
        textDisplay = new TextArea();
        textDisplay.setMaxWidth(150);
        textDisplay.setMaxHeight(5);

        // Creates a ListView containing Person class
        ListView<Person> personLV = new ListView<>(FXCollections.observableArrayList(personArray));
        personLV.setPrefSize(150, 200);
        // Creates a CellFactory organizing the List in a readable way
        personLV.setCellFactory(new PersonCellFactory());
        // Allows the name to be printed below when object is clicked from the list
        personLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            public void changed(ObservableValue<? extends Person> ov, Person oldValue, Person newValue) {
                nameDisplay(ov, newValue);
            }
        });

        // adds all the Person objects to the visual list
        HBox selection = new HBox();
        selection.getChildren().addAll(personLV);

        // combines the Person list and text display
        VBox root = new VBox();
        root.getChildren().addAll(selection, textDisplay);

        // Sets the GUI
        Scene scene = new Scene(root);
        primaryStage.setTitle("Person List View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Used to display the text at the bottom
    public void nameDisplay(ObservableValue<? extends Person> observable, Person input) {
        textDisplay.setText(input.getFirst() + " " + input.getLast());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Used to display to format how each object is shown in the List
class PersonCell extends ListCell<Person> {
    public void updateItem(Person input, boolean empty) {
        super.updateItem(input, empty);
        // it's null if there is no object
        if (input == null || empty) {
            this.setText(null);
        }
        // Objects show with last name, comma, then first name
        else {
            this.setText(input.getLast() + "," + input.getFirst());
        }
    }
}

// contains each of the Person Cells
class PersonCellFactory implements Callback<ListView<Person>, ListCell<Person>> {
    public ListCell<Person> call(ListView<Person> listview) {
        return new PersonCell();
    }
}

// The main object being contained in the list
class Person {
    private String fname;
    private String lname;

    // Constructor requires both first and last name to avoid nulls
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    // Get Methods
    public String getFirst() {
        return fname;
    }

    public String getLast() {
        return lname;
    }

    // Set Methods
    public void setFirst(String fname) {
        this.fname = fname;
    }

    public void setLast(String lname) {
        this.lname = lname;
    }
}
