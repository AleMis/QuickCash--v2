package pl.my.quickcash.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

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

    @FXML private BorderPane clientBorderPane;

    @FXML private TextField accountBalanceTextField;

    public TextField getAccountBalanceTextField() {
        return accountBalanceTextField;
    }

    public void setAccountBalanceTextField(TextField accountBalanceTextField) {
        this.accountBalanceTextField = accountBalanceTextField;
    }

    public void initialize() {

    }

    public void initSession() {
        initializeAccountBalance();
        setCaspian();
    }

    @FXML
    public void initMakeTransfer() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAKE_TRANSFER_FXML));
        try {
            clientBorderPane.setCenter(loader.load());
            MakeTransferPanelController controller = loader.<MakeTransferPanelController>getController();
            controller.setClientKey(getClientKey());
        } catch (Exception e) {
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
        } catch (Exception e) {
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
            clientBorderPane.getStylesheets().add(getClass().getClassLoader().getResource("/fxml/ClientDataPanel.css").toString());
        } catch (Exception e) {
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
            controller.initClientPersonalInformation();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
    public void closeApplication() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForCloseApp();
        if(result.get()==ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void about() {
        DialogUtils.dialogAboutApplication();
    }

    public void initializeAccountBalance() {
        accountBalanceTextField.setText(String.valueOf(ClientsDatabase.getInstance().get(getClientKey()).getClientAccounts().getAccountBalance()));
        accountBalanceTextField.setEditable(false);
    }
}