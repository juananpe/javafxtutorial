package fi.pelam.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox vBox = new VBox(new Label("A JavaFX Label"));
        Scene scene = new Scene(vBox);

        stage.setTitle("JavaFX Stage Window Title");
        stage.setScene(scene);

        // scene.getRoot().setCursor(Cursor.CROSSHAIR);

        //  stage.setFullScreen(true);

        stage.setX(50);
        stage.setY(50);

        stage.setWidth(600);
        stage.setHeight(300);


//        stage.initStyle(StageStyle.DECORATED);

// stage.initStyle(StageStyle.UNDECORATED);
// stage.initStyle(StageStyle.TRANSPARENT);
// stage.initStyle(StageStyle.UNIFIED);
// stage.initStyle(StageStyle.UTILITY);

        stage.show();

//        Stage stageAux = new Stage();
//        stageAux.initModality(Modality.APPLICATION_MODAL);
//        //stage.initModality(Modality.WINDOW_MODAL);
//        //stage.initModality(Modality.NONE);
//        stageAux.showAndWait();

    }
 }