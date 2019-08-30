package ehu.isad.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonExperimentsAccelerators extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HBox Experiment 1");

        Label label = new Label("Not clicked");
        // beware macOS users...
        // https://stackoverflow.com/a/24500058/243532
        Button button = new Button();
        button.setMnemonicParsing(true);
        button.setText("_Click");

        // alternative accelerator keys for macOS users
        KeyCombination kc = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN);
        Runnable task = () -> button.fire();

        button.setOnAction(value ->  {
           label.setText("Clicked!");
        });

        HBox hbox = new HBox(button, label);

        Scene scene = new Scene(hbox, 200, 100);
        // macOS users
        scene.getAccelerators().put(kc, task);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}