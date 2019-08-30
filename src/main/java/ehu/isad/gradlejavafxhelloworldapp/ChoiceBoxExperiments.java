package ehu.isad.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ChoiceBoxExperiments extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ChoiceBox Experiment 1");

        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("Choice 1");
        choiceBox.getItems().add("Choice 2");
        choiceBox.getItems().add("Choice 3");

        choiceBox.setOnAction(e -> {
            System.out.println( choiceBox.getValue());
        });


        HBox hbox = new HBox(choiceBox);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}