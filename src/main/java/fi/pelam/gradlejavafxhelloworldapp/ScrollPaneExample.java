package fi.pelam.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ScrollPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {

        ScrollPane scrollPane = new ScrollPane();

        InputStream is = getClass().getResourceAsStream("/aerial-beverage-caffeine.jpg");
        BufferedImage reader = ImageIO.read(is);
        Image image = SwingFXUtils.toFXImage(reader,null);
        ImageView imageView = new ImageView(image);

        scrollPane.setContent(imageView);
        scrollPane.pannableProperty().set(true);

        Scene scene = new Scene(scrollPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
    }
}