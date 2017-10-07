package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientPersonalDataFx;
import pl.my.quickcash.data.client.ClientPersonalData;

public class ClientPersonalDataConverter {

    public static ClientPersonalData convertToClientPersonalData(ClientPersonalDataFx clientPersonalDataFx) {
        ClientPersonalData clientPersonalData = new ClientPersonalData(clientPersonalDataFx.getFirstName(),
                                                                        clientPersonalDataFx.getLastName(),
                                                                        clientPersonalDataFx.getPesel(),
                                                                        clientPersonalDataFx.getIdCard(),
                                                                        clientPersonalDataFx.getCountry(),
                                                                        clientPersonalDataFx.getVoivodeship(),
                                                                        clientPersonalDataFx.getCity(),
                                                                        clientPersonalDataFx.getStreet(),
                                                                        clientPersonalDataFx.getBuildingNumber(),
                                                                        clientPersonalDataFx.getFlatNumber());
        return clientPersonalData;
    }

    public static ClientPersonalDataFx convertToClientPersonalDataFx(ClientPersonalData clientPersonalData) {
        ClientPersonalDataFx clientPersonalDataFx = new ClientPersonalDataFx();
        clientPersonalDataFx.setFirstName(clientPersonalData.getFirstName());
        clientPersonalDataFx.setLastName(clientPersonalData.getLastName());
        clientPersonalDataFx.setPesel(clientPersonalData.getPesel());
        clientPersonalDataFx.setIdCard(clientPersonalData.getIdCard());
        clientPersonalDataFx.setCountry(clientPersonalData.getCountry());
        clientPersonalDataFx.setVoivodeship(clientPersonalData.getVoivodeship());
        clientPersonalDataFx.setCity(clientPersonalData.getCity());
        clientPersonalDataFx.setStreet(clientPersonalData.getStreet());
        clientPersonalDataFx.setBuildingNumber(clientPersonalData.getBuildingNumber());
        clientPersonalDataFx.setFlatNumber(clientPersonalData.getFlatNumber());
        return clientPersonalDataFx;
    }
}
