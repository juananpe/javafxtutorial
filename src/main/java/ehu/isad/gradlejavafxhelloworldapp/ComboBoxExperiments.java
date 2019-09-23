package ehu.isad.gradlejavafxhelloworldapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void init() throws Exception {
        super.init();

        System.out.println("init()");
        Parameters parameters = getParameters();

        Map<String, String> namedParameters = parameters.getNamed();

        System.out.println(namedParameters.get("agurra"));

        List<String> rawArguments = parameters.getRaw();
        List<String> unnamedParameters = parameters.getUnnamed();

        System.out.println("\nnamedParameters -");
        for (Map.Entry<String,String> entry : namedParameters.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nrawArguments -");
        for(String raw : rawArguments) {
            System.out.println(raw);
        }

        System.out.println("\nunnamedParameters -");
        for(String unnamed : unnamedParameters) {
            System.out.println(unnamed);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println(getParameters().getNamed().toString());
        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Choice 1");
        comboBox.getItems().add("Choice 2");
        comboBox.getItems().add("Choice 3");

        comboBox.setEditable(true);

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());
        });

        HBox hbox = new HBox(comboBox);

        Scene scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
