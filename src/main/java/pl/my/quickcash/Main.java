package pl.my.quickcash;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.sample_users.SampleClient;
import pl.my.quickcash.sample_users.SampleEmployee;

import static javafx.application.Application.launch;

public class Main extends Application{

    public static final Stage stage = new Stage();

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SampleClient.createTestClients();
        SampleEmployee.createTestClients();

        Start start = new Start();
        start.showStarterPanel(stage);
        stage.setScene(Start.scene);
        stage.setTitle("QUICK CASH APPLICATION");
        stage.show();
    }
}