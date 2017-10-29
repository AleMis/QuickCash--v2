package pl.my.quickcash.controllers.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.data.client.ClientKey;

import java.io.IOException;

public class UpdateAccountBalance {

    private static final String CLIENT_MAIN_PANEL_FXML = "/fxml/ClientMainPanel.fxml";

    public UpdateAccountBalance() {
    }

    public void updateAccountBalance(ClientKey clientKey) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(CLIENT_MAIN_PANEL_FXML));
        try {
            Start.scene.setRoot((Parent) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientMainPanelController controller = loader.<ClientMainPanelController>getController();
        controller.setClientKey(clientKey);
        controller.initSession();
    }
}
