package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

public class ClientDataPanelController {

    private static final String UPDATE_CLIENT_CONTACT_DETAILS = "ClientContactDetails.updateClientContactDetails";
    private static final String SELECT_CLIENT_CONTACT_DETAILS_BY_ID = "ClientContactDetails.selectClientContactDetails";
    private static final String SELECT_CLIENT_PERSONAL_DATA_BY_ID = "ClientPersonalData.selectClientPersonalData";

    @FXML private TextField firstNameTextField;
    @FXML private TextField idNumberTextField;
    @FXML private TextField countryTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField buildingNoTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField peselTextField;
    @FXML private TextField voivodeshipTextField;
    @FXML private TextField streetTextField;
    @FXML private TextField flatNoTextField;
    @FXML private TextField countryCDTextField;
    @FXML private TextField cityCDTextField;
    @FXML private TextField buildingNoCDTextField;
    @FXML private TextField voivodeshipCDTextField;
    @FXML private TextField streetCDTextField;
    @FXML private TextField flatNoCDTextField;

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    public void initialize() {
    }

    public void initClientPersonalInformation() {
      initClientPersonalData();
      initClientContactDetails();
    }

    public void initClientPersonalData() {
        ClientPersonalData clientPersonalData = CommunicationDAO.selectById(SELECT_CLIENT_PERSONAL_DATA_BY_ID, getClientKey().getClient_key_id());

        String firstName = clientPersonalData.getFirstName();
        String lastName = clientPersonalData.getLastName();
        String pesel = clientPersonalData.getPesel();
        String idCard = clientPersonalData.getIdCard();
        String country = clientPersonalData.getCountry();
        String voivodeship = clientPersonalData.getVoivodeship();
        String city = clientPersonalData.getCity();
        String street = clientPersonalData.getStreet();
        String buildingNumber = clientPersonalData.getBuildingNumber();
        String flatNumber = clientPersonalData.getFlatNumber();

        firstNameTextField.setText(firstName);
        lastNameTextField.setText(lastName);
        idNumberTextField.setText(idCard);
        peselTextField.setText(pesel);
        countryTextField.setText(country);
        voivodeshipTextField.setText(voivodeship);
        cityTextField.setText(city);
        streetTextField.setText(street);
        buildingNoTextField.setText(buildingNumber);
        flatNoTextField.setText(flatNumber);

        disableEditPersonalInformatioTextFields();
    }

    public void initClientContactDetails() {
        ClientContactDetails clientContactDetails = (ClientContactDetails) CommunicationDAO.selectById(SELECT_CLIENT_CONTACT_DETAILS_BY_ID, getClientKey().getClient_key_id());

        String countryCD = clientContactDetails.getCountryCD();
        String voivodeshipCD = clientContactDetails.getVoivodeshipCD();
        String cityCD = clientContactDetails.getCityCD();
        String streetCD = clientContactDetails.getStreetCD();
        String buildingNumberCD = clientContactDetails.getBuildingNumberCD();
        String flatNumberCD = clientContactDetails.getFlatNumberCD();

        countryCDTextField.setText(countryCD);
        voivodeshipCDTextField.setText(voivodeshipCD);
        cityCDTextField.setText(cityCD);
        streetCDTextField.setText(streetCD);
        buildingNoCDTextField.setText(buildingNumberCD);
        flatNoCDTextField.setText(flatNumberCD);
        disableEditCDTextFields();
    }

    @FXML
    public void approveChangesContactDetails() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForContactDetails();
        if(result.get()==ButtonType.OK){
            enableEditCDTextField();
        }
    }

    @FXML
    public void approveChangesInContactDetails() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForContactDetailsSaving();
        if(result.get() == ButtonType.OK) {
            saveChangesInContactDetails();
            disableEditCDTextFields();
        }
    }

    public void saveChangesInContactDetails() {
        ClientContactDetails clientContactDetails = (ClientContactDetails) CommunicationDAO.selectById(SELECT_CLIENT_CONTACT_DETAILS_BY_ID, getClientKey().getClient_key_id());

        clientContactDetails.setCountryCD(countryCDTextField.getText());
        clientContactDetails.setVoivodeshipCD(voivodeshipCDTextField.getText());
        clientContactDetails.setCityCD(cityCDTextField.getText());
        clientContactDetails.setStreetCD(streetCDTextField.getText());
        clientContactDetails.setBuildingNumberCD(buildingNoCDTextField.getText());
        clientContactDetails.setFlatNumberCD(flatNoCDTextField.getText());

        CommunicationDAO.update(UPDATE_CLIENT_CONTACT_DETAILS,clientContactDetails);
        disableEditCDTextFields();
    }

    public void disableEditCDTextFields() {
        countryCDTextField.setEditable(false);
        voivodeshipCDTextField.setEditable(false);
        cityCDTextField.setEditable(false);
        streetCDTextField.setEditable(false);
        buildingNoCDTextField.setEditable(false);
        flatNoCDTextField.setEditable(false);
    }

    public void enableEditCDTextField() {
        countryCDTextField.setEditable(true);
        voivodeshipCDTextField.setEditable(true);
        cityCDTextField.setEditable(true);
        streetCDTextField.setEditable(true);
        buildingNoCDTextField.setEditable(true);
        flatNoCDTextField.setEditable(true);
        voivodeshipTextField.setEditable(false);
    }

    public void disableEditPersonalInformatioTextFields() {
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        idNumberTextField.setEditable(false);
        peselTextField.setEditable(false);
        countryTextField.setEditable(false);
        cityTextField.setEditable(false);
        streetTextField.setEditable(false);
        buildingNoTextField.setEditable(false);
        flatNoTextField.setEditable(false);
    }
}
