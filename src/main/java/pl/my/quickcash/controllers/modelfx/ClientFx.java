package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ClientFx {

    private ObjectProperty<ClientKeyFx> clientKeyFx = new SimpleObjectProperty<>();
    private ObjectProperty<ClientDataFx> clientDataFx = new SimpleObjectProperty<>();

    public ClientKeyFx getClientKeyFx() {
        return clientKeyFx.get();
    }

    public ObjectProperty<ClientKeyFx> clientKeyFxProperty() {
        return clientKeyFx;
    }

    public void setClientKeyFx(ClientKeyFx clientKeyFx) {
        this.clientKeyFx.set(clientKeyFx);
    }

    public ClientDataFx getClientDataFx() {
        return clientDataFx.get();
    }

    public ObjectProperty<ClientDataFx> clientDataFxProperty() {
        return clientDataFx;
    }

    public void setClientDataFx(ClientDataFx clientDataFx) {
        this.clientDataFx.set(clientDataFx);
    }

    @Override
    public String toString() {
        return clientKeyFx + "" + clientDataFx;
    }
}