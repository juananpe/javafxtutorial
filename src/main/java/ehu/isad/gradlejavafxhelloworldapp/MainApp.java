package ehu.isad.gradlejavafxhelloworldapp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("AddressApp");

    initRootLayout();
    showPersonOverview();
  }

  /**
   * Initializes the root layout.
   */
  public void initRootLayout() {
    try {
      // Load root layout from fxml file.
      rootLayout = (BorderPane) FXMLLoader.load(getClass().getResource("/RootLayout.fxml"));

      // Show the scene containing the root layout.
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Shows the person overview inside the root layout.
   */
  public void showPersonOverview() {
    try {
      // Load person overview.
      AnchorPane personOverview = (AnchorPane) FXMLLoader.load(getClass().getResource("/PersonOverview.fxml"));
      // Set person overview into the center of root layout.
      rootLayout.setCenter(personOverview);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the main stage.
   *
   * @return
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) {
    launch(args);
  }
}