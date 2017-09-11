package pl.my.quickcash.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;

import javax.swing.border.Border;

public class ClientMainPanelController {

    @FXML
    private Pane clientPane;

    @FXML
    private Label testLabel;


    private final ObjectProperty<ClientKey> clientKey = new SimpleObjectProperty<>();

    public final ObjectProperty<ClientKey> clientKeyProperty() {
        return this.clientKey;
    }

    public final ClientKey getClientKey() {
        return this.clientKeyProperty().get();
    }

    public final void setClientKey(final ClientKey clientKey) {
        this.clientKeyProperty().set(clientKey);
    }



    public void initialize() {
        clientKey.addListener((obs, oldClient, newClient) -> setLabelText(newClient));
    }

    public void setLabelText(ClientKey clientKey) {
        clientPane.autosize();
        testLabel.setText(ClientsDatabase.getInstance().get(clientKey).getPersonalData().getFirstName());
    }




}
