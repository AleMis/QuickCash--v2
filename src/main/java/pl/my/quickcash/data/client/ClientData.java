package pl.my.quickcash.data.client;

public class ClientData {
    private ClientPersonalData personalData;
    private ClientContactDetails contactDetails;
    private ClientAccount clientAccounts;
    private Integer userNumber = 0;

    public ClientData(ClientPersonalData personalData, ClientContactDetails contactDetails, ClientAccount clientAccounts) {
        this.personalData = personalData;
        this.contactDetails = contactDetails;
        this.clientAccounts = clientAccounts;
    }

    public ClientPersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(ClientPersonalData personalData) {
        this.personalData = personalData;
    }

    public ClientContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ClientContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public ClientAccount getClientAccounts() {
        return clientAccounts;
    }

    public void setClientAccounts(ClientAccount clientAccounts) {
        this.clientAccounts = clientAccounts;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return  personalData + "" +contactDetails + "" + clientAccounts + "" + userNumber;
    }
}

