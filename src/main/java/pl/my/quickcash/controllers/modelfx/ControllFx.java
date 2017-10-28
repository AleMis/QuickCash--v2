package pl.my.quickcash.controllers.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import pl.my.quickcash.controllers.employee.LoadClientDatabase;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.data.converter.ClientConverter;
import pl.my.quickcash.data.converter.ClientDataConverter;
import pl.my.quickcash.data.converter.ClientKeyConverter;
import pl.my.quickcash.data.converter.ClientTransactionConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllFx {

    private ObservableList<ClientFx> clientsObservableFxList = FXCollections.observableArrayList();
    private List<ClientFx> clientsFxList = new ArrayList<>();
    private ObservableList<ClientTransactionFx> clientTransactionFxObservableList = FXCollections.observableArrayList();
    private List<ClientTransactionFx> clientTransactionFx = new ArrayList<>();

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    public ControllFx() {
    }

    public void initDatabase() {
        List<Client> clientList = LoadClientDatabase.getInstance();
        clientsFxList.clear();
        System.out.println(clientsFxList.size());
        clientList.forEach(client -> {
            this.clientsFxList.add(ClientConverter.convertToClientFx(client));
        });
        System.out.println(clientsFxList.size());
        this.clientsObservableFxList.setAll(clientsFxList);
    }

    public void initClientTransactionHistory() {
        List<ClientTransaction> transactionHistory = ClientTransaction.createClientTransaction(getClientKey());
        clientTransactionFx.clear();
        transactionHistory.forEach(transaction -> {
            this.clientTransactionFx.add(ClientTransactionConverter.convertToClientTransactionFx(transaction));
        });
        this.clientTransactionFxObservableList.setAll(clientTransactionFx);
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

    public ObservableList<ClientTransactionFx> getClientTransactionFxObservableList() {
        return clientTransactionFxObservableList;
    }

    public void setClientTransactionFxObservableList(ObservableList<ClientTransactionFx> clientTransactionFxObservableList) {
        this.clientTransactionFxObservableList = clientTransactionFxObservableList;
    }

    public List<ClientTransactionFx> getClientTransactionFx() {
        return clientTransactionFx;
    }

    public void setClientTransactionFx(List<ClientTransactionFx> clientTransactionFx) {
        this.clientTransactionFx = clientTransactionFx;
    }
}
