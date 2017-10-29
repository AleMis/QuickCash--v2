package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ClientDataFx {

    private ObjectProperty<ClientPersonalDataFx> personalData = new SimpleObjectProperty<>();
    private ObjectProperty<ClientContactDetailsFx> contactDetails = new SimpleObjectProperty<>();
    private ObjectProperty<ClientAccountFx> clientAccounts = new SimpleObjectProperty<>();


    public ClientPersonalDataFx getPersonalData() {
        return personalData.get();
    }

    public ObjectProperty<ClientPersonalDataFx> personalDataProperty() {
        return personalData;
    }

    public void setPersonalData(ClientPersonalDataFx personalData) {
        this.personalData.set(personalData);
    }

    public ClientContactDetailsFx getContactDetails() {
        return contactDetails.get();
    }

    public ObjectProperty<ClientContactDetailsFx> contactDetailsProperty() {
        return contactDetails;
    }

    public void setContactDetails(ClientContactDetailsFx contactDetails) {
        this.contactDetails.set(contactDetails);
    }

    public ClientAccountFx getClientAccounts() {
        return clientAccounts.get();
    }

    public ObjectProperty<ClientAccountFx> clientAccountsProperty() {
        return clientAccounts;
    }

    public void setClientAccounts(ClientAccountFx clientAccounts) {
        this.clientAccounts.set(clientAccounts);
    }

    @Override
    public String toString() {
        return personalData + "" + contactDetails + "" + clientAccounts;
    }
}
