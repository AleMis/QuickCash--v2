package pl.my.quickcash;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.my.quickcash.dao.clients.ClientDatabaseDAO;
import pl.my.quickcash.dao.employee.EmployeeDatabaseDAO;
import pl.my.quickcash.data.client.Client;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.util.HashMap;
import java.util.Map;

import static javafx.application.Application.launch;

public class Main extends Application{


    public static void main(String[] args) {
        launch(args);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        ClientsDatabase.getInstance();
//        EmployeesDatabase.getInstance();
//
//        Start start = new Start();
//        start.showStarterPanel(primaryStage);
//        primaryStage.setScene(Start.scene);
//        primaryStage.setTitle("QUICK CASH APPLICATION");
//        primaryStage.show();

        HashMap<EmployeeKey, EmployeeData> data = EmployeeDatabaseDAO.getInstance();

        for(Map.Entry<EmployeeKey, EmployeeData> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        HashMap<ClientKey, ClientData> clients = ClientDatabaseDAO.getInstance();

        for(Map.Entry<ClientKey, ClientData> entry : clients.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}