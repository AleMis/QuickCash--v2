package pl.my.quickcash.controllers.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.employee.ClientsDatabasePanelController;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.controllers.modelfx.ControllFx;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientTransaction;
import pl.my.quickcash.dialogs.DialogUtils;

import java.io.IOException;
import java.util.Optional;

public class ClientMainPanelController {

    private static final String MAKE_TRANSFER_FXML = "/fxml/MakeTransferPanel.fxml";
    private static final String PUT_MONEY_FXML = "/fxml/PutMoneyPanel.fxml";
    private static final String WITHDRAW_MONEY_FXML = "/fxml/WithdrawMoneyPanel.fxml";
    private static final String CLIENT_DATA_FXML = "/fxml/ClientDataPanel.fxml";
    private static final String SHOW_CLIENT_TRANSACTION_HISTORY_FXML = "/fxml/ClientTransactionPanel.fxml";
    private static final String SELECT_CLIENT_ACCOUNT = "ClientAccount.selectClientAccount";

    private ClientKey clientKey;
    private ControllFx controllFx = new ControllFx();

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML private BorderPane clientBorderPane;
    @FXML private TextField accountBalanceTextField;


    public void initSession() {
        initializeAccountBalance();
        setModena();
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

    @FXML
    public void initClientTransactionHistory() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SHOW_CLIENT_TRANSACTION_HISTORY_FXML));
        Stage stage = new Stage();
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        controllFx.setClientKey(getClientKey());
        controllFx.initClientTransactionHistory();
        ClientTransactionPanelController controller = loader.getController();
        controller.setControllFx(controllFx);
    }


    public void closeApplication() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForCloseApp();
        if(result.get()==ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    @FXML
    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    @FXML
    public void about() {
        DialogUtils.dialogAboutApplication();
    }

    @FXML
    public void logout(){
        StarterPanelController.backToStarterPanel();
    }

    public void initializeAccountBalance() {
        ClientAccount clientAccount = CommunicationDAO.selectById(SELECT_CLIENT_ACCOUNT, getClientKey().getClientKeyId());
        accountBalanceTextField.setText(String.valueOf(clientAccount.getAccountBalance()));
        accountBalanceTextField.setEditable(false);
    }
}