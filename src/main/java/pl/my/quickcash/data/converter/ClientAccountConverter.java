package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientAccountFx;
import pl.my.quickcash.data.client.ClientAccount;

public class ClientAccountConverter {

    public static ClientAccount convertToAccount(ClientAccountFx clientAccountFx) {
        ClientAccount clientAccount = new ClientAccount(clientAccountFx.getAccountBalance(), clientAccountFx.getAccountNumber());
        return clientAccount;
    }

    public static ClientAccountFx convertToAccountFx(ClientAccount clientAccount) {
        ClientAccountFx clientAccountFx = new ClientAccountFx();
        clientAccountFx.setAccountBalance(clientAccount.getAccountBalance());
        clientAccountFx.setAccountNumber(clientAccount.getAccountNumber());
        return clientAccountFx;
    }
}
