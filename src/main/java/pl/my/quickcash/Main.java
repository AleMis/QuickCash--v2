package pl.my.quickcash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.LoginController;
import pl.my.quickcash.controllers.Start;
import pl.my.quickcash.data.ClientsDatabase;

import static javafx.application.Application.launch;

public class Main extends Application{



    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientsDatabase.getInstance();
        
        Start start = new Start();
        start.showStarterPanel(primaryStage);
        primaryStage.setScene(Start.scene);
        primaryStage.show();


    }
}