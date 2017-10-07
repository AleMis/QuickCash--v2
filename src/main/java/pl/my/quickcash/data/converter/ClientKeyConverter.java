package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientKeyFx;
import pl.my.quickcash.data.client.ClientKey;

public class ClientKeyConverter {

    public static ClientKey convertToClientKey(ClientKeyFx clientKeyFx) {
        ClientKey clientKey = new ClientKey(clientKeyFx.getLogin(), clientKeyFx.getPassword());
        return clientKey;
    }

    public static ClientKeyFx convertToClientKeyFx(ClientKey clientKey) {
        ClientKeyFx clientKeyFx = new ClientKeyFx();
        clientKeyFx.setLogin(clientKey.getLogin());
        clientKeyFx.setPassword(clientKey.getPassword());
        return clientKeyFx;
    }
}
