package pl.my.quickcash;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientKeyDAO;
import pl.my.quickcash.dao.clients.ClientPersonalDataDAO;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientPersonalData;

import static javafx.application.Application.launch;

public class Main extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Start start = new Start();
        start.showStarterPanel(primaryStage);
        primaryStage.setScene(Start.scene);
        primaryStage.setTitle("QUICK CASH APPLICATION");
        primaryStage.show();
    }
}