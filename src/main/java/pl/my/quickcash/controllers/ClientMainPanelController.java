package pl.my.quickcash.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;

public class ClientMainPanelController {

    private static final String MAKE_TRANSFER_FXML = "/fxml/MakeTransferPanel.fxml";
    private static final String PUT_MONEY_FXML = "/fxml/PutMoneyPanel.fxml";
    private static final String WITHDRAW_MONEY_FXML = "/fxml/WithdrawMoneyPanel.fxml";
    private static final String CLIENT_DATA_FXML = "/fxml/ClientDataPanel.fxml";

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    private BorderPane clientBorderPane;

    @FXML
    private TextField accountBalanceTextField;

    @FXML
    private Button makeTransferButton;

    @FXML
    private Button putMoneyButton;

    @FXML
    private Button withdrawMoneyButton;

    @FXML
    private Button personalData;


    public void initialize() {

    }

    public void initSession(final LoginController loginController, ClientKey clientKey) {
        accountBalanceTextField.setText(String.valueOf(ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance()));

    }

    @FXML
    public void initMakeTransfer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAKE_TRANSFER_FXML));
        try {
            clientBorderPane.setCenter(loader.load());
            MakeTransferPanelController controller = loader.<MakeTransferPanelController>getController();
            controller.setClientKey(getClientKey());
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void initPutMoney() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(PUT_MONEY_FXML));
        try {
            clientBorderPane.setCenter(loader.load());
            PutMoneyPanelController controller = loader.<PutMoneyPanelController>getController();
            controller.setClientKey(getClientKey());
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void initWithdrawMoney() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(WITHDRAW_MONEY_FXML));
        try {
            clientBorderPane.setCenter(loader.load());
            WithdrawMoneyPanelController controller = loader.<WithdrawMoneyPanelController>getController();
            controller.setClientKey(getClientKey());
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void initCheckPersonalData() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(CLIENT_DATA_FXML));
        try {
            clientBorderPane.setCenter(loader.load());
            ClientDataPanelController controller = loader.<ClientDataPanelController>getController();
            controller.setClientKey(getClientKey());
        }catch (Exception e) {
            e.getStackTrace();
        }

    }





}