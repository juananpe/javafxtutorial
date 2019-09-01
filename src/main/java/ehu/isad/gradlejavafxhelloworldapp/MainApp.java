package ehu.isad.gradlejavafxhelloworldapp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import ehu.isad.gradlejavafxhelloworldapp.controller.PersonEditDialogController;
import ehu.isad.gradlejavafxhelloworldapp.controller.PersonOverviewController;
import ehu.isad.gradlejavafxhelloworldapp.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  /**
   * The data as an observable list of Persons.
   */
  private ObservableList<Person> personData = FXCollections.observableArrayList();

  /**
   * Constructor
   */
  public MainApp() {
    // Add some sample data
    personData.add(new Person("Hans", "Muster"));
    personData.add(new Person("Ruth", "Mueller"));
    personData.add(new Person("Heinz", "Kurz"));
    personData.add(new Person("Cornelia", "Meier"));
    personData.add(new Person("Werner", "Meyer"));
    personData.add(new Person("Lydia", "Kunz"));
    personData.add(new Person("Anna", "Best"));
    personData.add(new Person("Stefan", "Meier"));
    personData.add(new Person("Martin", "Mueller"));
  }

  /**
   * Returns the data as an observable list of Persons.
   *
   * @return
   */
  public ObservableList<Person> getPersonData() {
    return personData;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("AddressApp");


    URL iconURL = getClass().getResource("/address_book.png");
    java.awt.Image image = new ImageIcon(iconURL).getImage();
    Taskbar taskbar=Taskbar.getTaskbar();
    taskbar.setIconImage(image);


    InputStream is = getClass().getResourceAsStream("/address_book.png");
    BufferedImage reader = ImageIO.read(is);
    Image imagefx = SwingFXUtils.toFXImage(reader, null);
    this.primaryStage.getIcons().add(imagefx);


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
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/PersonOverview.fxml"));
      AnchorPane personOverview = (AnchorPane) loader.load();

      // AnchorPane personOverview = (AnchorPane) FXMLLoader.load(getClass().getResource("/PersonOverview.fxml"));

      // Set person overview into the center of root layout.
      rootLayout.setCenter(personOverview);

      // Give the controller access to the main app.
      PersonOverviewController controller = loader.getController();
      controller.setMainApp(this);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Opens a dialog to edit details for the specified person. If the user
   * clicks OK, the changes are saved into the provided person object and true
   * is returned.
   *
   * @param person the person object to be edited
   * @return true if the user clicked OK, false otherwise.
   */
  public boolean showPersonEditDialog(Person person) {
    try {
      // Load the fxml file and create a new stage for the popup dialog.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/PersonEditDialog.fxml"));
      AnchorPane page = (AnchorPane) loader.load();

      // Create the dialog Stage.
      Stage dialogStage = new Stage();
      dialogStage.setTitle("Edit Person");
      dialogStage.initModality(Modality.WINDOW_MODAL);
      dialogStage.initOwner(primaryStage);
      Scene scene = new Scene(page);
      dialogStage.setScene(scene);

      // Set the person into the controller.
      PersonEditDialogController controller = loader.getController();
      controller.setDialogStage(dialogStage);
      controller.setPerson(person);

      // Show the dialog and wait until the user closes it
      dialogStage.showAndWait();

      return controller.isOkClicked();
    } catch (IOException e) {
      e.printStackTrace();
      return false;
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