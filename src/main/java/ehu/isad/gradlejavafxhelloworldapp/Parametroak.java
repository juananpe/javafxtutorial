package ehu.isad.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;


public class Parametroak extends Application {

  @Override
  public void init() throws Exception {
    super.init();

    Parameters parameters = getParameters();
    Map<String, String> namedParameters = parameters.getNamed();
    if (namedParameters.containsKey("agurra"))
        System.out.println(namedParameters.get("agurra"));

  }


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Parametroak nola kudeatu");
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
