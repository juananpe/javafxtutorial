package fi.pelam.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ColorPickerExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        ColorPicker colorPicker = new ColorPicker();

        Button button = new Button("Read Date");

        button.setOnAction(action -> {
            Color value = colorPicker.getValue();
            System.out.println(value);
        });

        VBox vBox = new VBox(colorPicker, button);

        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}