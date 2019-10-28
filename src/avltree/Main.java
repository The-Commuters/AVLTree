package avltree;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * To start the AVL tree generator
 *
 * @author Markus Fenes
 * @author Mads Hagen
 */

public class Main extends Application {

    Button btnTest;

    Label textInputLabel = new Label("Number to add");

    TextField input;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane rootPane = new BorderPane();
        Pane drawPane = new Pane();

        btnTest = new Button();
        btnTest.setText("Test");

        input = new TextField();

        drawPane.setStyle("-fx-background-color: white;" + "-fx-border-color: black");


        HBox buttonBar = new HBox(10);

        // Sets the buttonBar element in center, and expands from there, so all the elements will start in the middle and go out from here.
        buttonBar.setAlignment(Pos.CENTER);

        //Sets the buttonBar element 10 pixels from the top of the application and 10 pixels above the drawPane
        buttonBar.setPadding(new Insets(10, 0, 10, 0));

        // Adds all the gui elements in turn to the HBox buttonBar
        buttonBar.getChildren().addAll(btnTest, textInputLabel, input );



        rootPane.setTop(buttonBar);
        rootPane.setCenter(drawPane);

        Scene scene = new Scene(rootPane);

        primaryStage.setTitle("AVL-tree generator");
        primaryStage.setHeight(500);
        primaryStage.setWidth(1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        AVLTre<Integer> t = new AVLTre<>(7);

        int[] innTab = {5, 4, 3, 2, 6, 12, 15, 9};
        for(int curentNumber : innTab){
            t.add(curentNumber);
            System.out.print(" | " + curentNumber);
        }
        System.out.println("\nsize of: " + t.size());
        System.out.println("height of: " + t.height());

        int[] findTab = {5, 31, 14, 15, 9};
        for(int currentNumber : findTab){
            Integer target;
            target = t.find(currentNumber);
            if(target == null){
                System.out.println(currentNumber + " Could not be found");
            }
            else{
                System.out.println(target + " found");
            }
        }

        launch(args);
    }
}
