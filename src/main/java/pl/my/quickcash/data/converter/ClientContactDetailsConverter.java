package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientContactDetailsFx;
import pl.my.quickcash.controllers.modelfx.ClientPersonalDataFx;
import pl.my.quickcash.data.client.ClientContactDetails;
import pl.my.quickcash.data.client.ClientPersonalData;

public class ClientContactDetailsConverter {

    public static ClientContactDetails convertToClientContactDetails(ClientContactDetailsFx clientContactDetailsFx) {
        ClientContactDetails clientContactDetails = new ClientContactDetails(clientContactDetailsFx.getCountryCD(),
                                                                            clientContactDetailsFx.getVoivodeshipCD(),
                                                                            clientContactDetailsFx.getCityCD(),
                                                                            clientContactDetailsFx.getStreetCD(),
                                                                            clientContactDetailsFx.getBuildingNumberCD(),
                                                                            clientContactDetailsFx.getFlatNumberCD(),
                                                                            1);
        return clientContactDetails;
    }

    public static ClientContactDetailsFx convertToClientContactDetailsFx(ClientContactDetails clientContactDetails) {
        ClientContactDetailsFx clientContactDetailsFx = new ClientContactDetailsFx();
        clientContactDetailsFx.setCountryCD(clientContactDetails.getCountryCD());
        clientContactDetailsFx.setVoivodeshipCD(clientContactDetails.getVoivodeshipCD());
        clientContactDetailsFx.setCityCD(clientContactDetails.getCityCD());
        clientContactDetailsFx.setStreetCD(clientContactDetails.getStreetCD());
        clientContactDetailsFx.setBuildingNumberCD(clientContactDetails.getBuildingNumberCD());
        clientContactDetailsFx.setFlatNumberCD(clientContactDetails.getFlatNumberCD());
        return clientContactDetailsFx;
    }
}
