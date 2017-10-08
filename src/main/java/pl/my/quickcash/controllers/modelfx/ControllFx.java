package pl.my.quickcash.controllers.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.data.converter.ClientConverter;
import pl.my.quickcash.data.converter.ClientDataConverter;
import pl.my.quickcash.data.converter.ClientKeyConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllFx {

    private ObservableList<ClientFx> clientsObservableFxList = FXCollections.observableArrayList();
    private List<ClientFx> clientsFxList = new ArrayList<>();


    public ControllFx() {
    }

    public void initDatabase() {

        List<Client> clientList = ClientsList.createList();
        clientsFxList.clear();
        clientList.forEach(client -> {
            this.clientsFxList.add(ClientConverter.convertToClientFx(client));
        });
        this.clientsObservableFxList.setAll(clientsFxList);
    }

    public ObservableList<ClientFx> getClientsObservableFxList() {
        return clientsObservableFxList;
    }

    public void setClientsObservableFxList(ObservableList<ClientFx> clientsObservableFxList) {
        this.clientsObservableFxList = clientsObservableFxList;
    }

    public List<ClientFx> getClientsFxList() {
        return clientsFxList;
    }

    public void setClientsFxList(List<ClientFx> clientsFxList) {
        this.clientsFxList = clientsFxList;
    }
}
