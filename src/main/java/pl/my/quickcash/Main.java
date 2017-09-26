package pl.my.quickcash;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.data.employee.EmployeesDatabase;

import static javafx.application.Application.launch;

public class Main extends Application{



    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientsDatabase.getInstance();
        EmployeesDatabase.getInstance();
        
        Start start = new Start();
        start.showStarterPanel(primaryStage);
        primaryStage.setScene(Start.scene);
        primaryStage.setTitle("QUICK CASH APPLICATION");
        primaryStage.show();


    }
}