package pl.my.quickcash;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.general.Start;
import sun.security.provider.SHA;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

import static javafx.application.Application.launch;

public class Main extends Application{


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        launch(args);







    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TestClient.createTestClients();

        Start start = new Start();
        start.showStarterPanel(primaryStage);
        primaryStage.setScene(Start.scene);
        primaryStage.setTitle("QUICK CASH APPLICATION");
        primaryStage.show();
    }
}