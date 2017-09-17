package pl.my.quickcash.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;

public class ClientDataPanelController {

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    private String firstName = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getFirstName();
    private String lastName = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getLastName();
    private String pesel = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getPesel();
    private String idCard = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getIdCard();
    private String country = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getCountry();
    private String voivodeship = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getVoivodeship();
    private String city = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getCity();
    private String street = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getStreet();
    private String buildingNumber = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getBuildingNumber();
    private String flatNumber = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getFlatNumber();

    private String countryCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getCountryCD();
    private String voivodeshipCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getVoivodeshipCD();
    private String cityCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getCityCD();
    private String streetCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getStreetCD();
    private String buildingNumberCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getBuildingNumberCD();
    private String flatNumberCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getFlatNumberCD();

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField idNumberTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField buildingNoTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField peselTextField;

    @FXML
    private TextField voivodeshipTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField flatNoTextField;

    @FXML
    private TextField countryCDTextField;

    @FXML
    private TextField cityCDTextField;

    @FXML
    private TextField buildingNoCDTextField;

    @FXML
    private TextField voivodeshipCDTextField;

    @FXML
    private TextField streetCDTextField;

    @FXML
    private TextField flatNoCDTextField;


//    public void initClientPersonalInformation() {
//        firstNameTextField.setText(firstName);
//        lastNameTextField.setText(lastName);
//        idNumberTextField.setText(idCard);
//        peselTextField.setText(pesel);
//        countryTextField.setText(country);
//        voivodeshipTextField.setText(voivodeship);
//        cityTextField.setText(city);
//        streetTextField.setText(street);
//        buildingNoTextField.setText(buildingNumber);
//        flatNoTextField.setText(flatNumber);
//    }
}
