package ehu.isad.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageViewExperiments extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ImageView Experiment 1");

//        String className = this.getClass().getSimpleName();
//        URL testPath = this.getClass().getResource(className+".class");
//        System.out.println("Current Running Location is :"+testPath);

        // System.out.println(new File(".").getAbsolutePath());
        // FileInputStream input = getClass().getClassLoader()
          //  .getResourceAsStream("images/home.png");
         // URL resource = getClass().getResource("/home.png");


      InputStream is = getClass().getResourceAsStream("/home.png");
      BufferedImage reader = ImageIO.read(is);
     // System.out.println(is);
      // BufferedReader reader = new BufferedReader(new InputStreamReader(is));

      Image image = SwingFXUtils.toFXImage(reader,null);

         // FileInputStream input = new FileInputStream(path);
         // FileInputStream input = new FileInputStream(resource.toExternalForm());
//
         // Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        HBox hbox = new HBox(imageView);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
