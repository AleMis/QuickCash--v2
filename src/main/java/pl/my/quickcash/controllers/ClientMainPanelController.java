package pl.my.quickcash.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;

public class ClientMainPanelController {

    @FXML
    private TextField accountBalanceTextField;




    public void initialize() {

    }

    public void initSessionID(final LoginController loginController, ClientKey clientKey) {
        accountBalanceTextField.setText(String.valueOf(ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance()));
    }
}