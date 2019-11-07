package AVLVisualTree;

import AVLTree.AVLTree;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * To start the AVL tree generator
 *
 * @author Markus Madsen Fenes
 * @author Mads Fredrik Hagen
 * @author David Naist Øvernes
 */

public class Main extends Application {

    Button btnTest;

    Label textInputLabel = new Label("Number to add");

    NumberTextField input;

    String inputString;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane rootPane = new BorderPane();
        StackPane drawPane = new StackPane();

        btnTest = new Button();
        btnTest.setText("Test");

        input = new NumberTextField();

        AVLVisualTree<Integer> visualTree = new AVLVisualTree<Integer>();


        input = new NumberTextField();

        btnTest.setOnAction(event -> {
            for (int i = 0; i <250 ; i++) {
                int rand = (int)(Math.random() * 1*i) + 10;
                visualTree.insert(rand);
            }


        });

        input.setOnKeyPressed(event -> {
            // Checks that the key entered is the enter button
            if(event.getCode() == KeyCode.ENTER){

                // Saves the inputted string in a variable so, that the text field can be cleared

                //Clears the input field after the user has pressed Enter

                // Check that the inputted value is a number, so that there will be no issues with this later on - DONE

                // Adds the value from the user to the tree using a method

                // This method will then add the value to the tree and then display it,
                // after it has placed it in to the correct sub/root node

                // The tree is updated and shown to the user and the input field will be ready for a new value to be entered
                visualTree.insert(Integer.parseInt(input.getText()));

                input.clear();



            }

        });

        drawPane.setStyle("-fx-background-color: white;" + "-fx-border-color: black");

        HBox buttonBar = new HBox(10);

        // Sets the buttonBar element in center, and expands from there, so all the elements will start in the middle and go out from here.
        buttonBar.setAlignment(Pos.CENTER);

        //Sets the buttonBar element 10 pixels from the top of the application and 10 pixels above the drawPane
        buttonBar.setPadding(new Insets(10, 0, 10, 0));

        // Adds all the gui elements in turn to the HBox buttonBar
        buttonBar.getChildren().addAll(btnTest, textInputLabel, input );

        // TEST //


        drawPane.getChildren().add(visualTree);
        // TEST //

        rootPane.setTop(buttonBar);
        rootPane.setCenter(drawPane);

        Scene scene = new Scene(rootPane);

        primaryStage.setTitle("AVL-tree generator");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(750);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
