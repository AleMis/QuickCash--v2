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
        clientAccount.setAccountBalance(clientAccount.getAccountBalance());
        clientAccount.setAccountNumber(clientAccount.getAccountNumber());
        return clientAccountFx;
    }
}
