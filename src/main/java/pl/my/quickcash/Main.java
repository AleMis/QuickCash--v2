package pl.my.quickcash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.my.quickcash.data.ClientsDatabase;

import static javafx.application.Application.launch;

public class Main extends Application{



    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientsDatabase.getInstance();
        try {
            Pane root = FXMLLoader.load(getClass().getResource("/fxml/ClientLoginPanel.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}