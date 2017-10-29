package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientFx;
import pl.my.quickcash.data.client.Client;

public class ClientConverter {

    public static Client convertToClient(ClientFx clientFx) {
        Client client = new Client(ClientKeyConverter.convertToClientKey(clientFx.getClientKeyFx()),
                                    ClientDataConverter.convertToClientData(clientFx.getClientDataFx()));
        return client;
    }

    public static ClientFx convertToClientFx(Client client) {
        ClientFx clientFx = new ClientFx();
        clientFx.setClientKeyFx(ClientKeyConverter.convertToClientKeyFx(client.getClientKey()));
        clientFx.setClientDataFx(ClientDataConverter.convertToClientDataFx(client.getClientData()));
        return clientFx;
    }
}
