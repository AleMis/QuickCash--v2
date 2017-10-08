package pl.my.quickcash.data.client;

public class Client {

    private ClientKey clientKey;
    private ClientData clientData;

    public Client(ClientKey clientKey, ClientData clientData) {
        this.clientKey = clientKey;
        this.clientData = clientData;
    }

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    @Override
    public String toString() {
        return clientKey + " "+ clientData;
    }
}
