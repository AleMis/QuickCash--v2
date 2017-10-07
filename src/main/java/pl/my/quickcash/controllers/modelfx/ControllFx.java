package pl.my.quickcash.controllers.modelfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.data.converter.ClientDataConverter;
import pl.my.quickcash.data.converter.ClientKeyConverter;

import java.util.HashMap;
import java.util.Map;

public class ControllFx {

    private ObservableMap<ClientKeyFx, ClientDataFx> databaseFx = FXCollections.observableHashMap();

    public ControllFx() {
    }

    public void addToDatabase() {

        HashMap<ClientKey, ClientData> database = ClientsDatabase.getInstance();
        databaseFx.clear();
        database.forEach((k, v) -> {
            this.databaseFx.put(ClientKeyConverter.convertToClientKeyFx(k), ClientDataConverter.convertToClientDataFx(v));
        });
    }

    public ObservableMap<ClientKeyFx, ClientDataFx> getDatabaseFx() {
        return databaseFx;
    }
}
