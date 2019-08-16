package fi.pelam.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ToggleButtonExperiments extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HBox Experiment 1");


        ToggleButton toggleButton1 = new ToggleButton("Left");
        ToggleButton toggleButton2 = new ToggleButton("Right");
        ToggleButton toggleButton3 = new ToggleButton("Up");
        ToggleButton toggleButton4 = new ToggleButton("Down");

        ToggleGroup toggleGroup = new ToggleGroup();

        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        toggleButton4.setToggleGroup(toggleGroup);

        toggleButton1.setOnAction(actionEventEventHandler(toggleGroup));
        toggleButton2.setOnAction(actionEventEventHandler(toggleGroup));
        toggleButton3.setOnAction(actionEventEventHandler(toggleGroup));
        toggleButton4.setOnAction(actionEventEventHandler(toggleGroup));


        HBox hbox = new HBox(toggleButton1, toggleButton2, toggleButton3, toggleButton4);


        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private EventHandler<ActionEvent> actionEventEventHandler(ToggleGroup toggleGroup) {
        return event -> {
            ToggleButton selectedToggleButton =
                (ToggleButton) toggleGroup.getSelectedToggle();
            System.out.println(selectedToggleButton);
        };
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}