package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientDataFx;
import pl.my.quickcash.data.client.ClientData;

public class ClientDataConverter {

    public static ClientData convertToClientData(ClientDataFx clientDataFx) {
        ClientData clientData = new ClientData(ClientPersonalDataConverter.convertToClientPersonalData(clientDataFx.getPersonalData()),
                                            ClientContactDetailsConverter.convertToClientContactDetails(clientDataFx.getContactDetails()),
                                            ClientAccountConverter.convertToAccount(clientDataFx.getClientAccounts()));
        return clientData;
    }

    public static ClientDataFx convertToClientDataFx(ClientData clientData) {
        ClientDataFx clientDataFx = new ClientDataFx();
        clientDataFx.setPersonalData(ClientPersonalDataConverter.convertToClientPersonalDataFx(clientData.getPersonalData()));
        clientDataFx.setContactDetails(ClientContactDetailsConverter.convertToClientContactDetailsFx(clientData.getContactDetails()));
        clientDataFx.setClientAccounts(ClientAccountConverter.convertToAccountFx(clientData.getClientAccounts()));
        return clientDataFx;
    }
}
