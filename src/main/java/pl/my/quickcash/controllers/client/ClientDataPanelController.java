package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

public class ClientDataPanelController {

    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

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

    public void initialize() {

    }

    public void initClientPersonalInformation() {

        String firstName = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getFirstName();
        String lastName = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getLastName();
        String pesel = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getPesel();
        String idCard = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getIdCard();
        String country = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getCountry();
        String voivodeship = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getVoivodeship();
        String city = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getCity();
        String street = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getStreet();
        String buildingNumber = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getBuildingNumber();
        String flatNumber = ClientsDatabase.getInstance().get(getClientKey()).getPersonalData().getFlatNumber();

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

        String countryCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getCountryCD();
        String voivodeshipCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getVoivodeshipCD();
        String cityCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getCityCD();
        String streetCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getStreetCD();
        String buildingNumberCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getBuildingNumberCD();
        String flatNumberCD = ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().getFlatNumberCD();

        countryCDTextField.setText(countryCD);
        voivodeshipCDTextField.setText(voivodeshipCD);
        cityCDTextField.setText(cityCD);
        streetCDTextField.setText(streetCD);
        buildingNoCDTextField.setText(buildingNumberCD);
        flatNoCDTextField.setText(flatNumberCD);
        disableEditCDTextFields();
    }

    @FXML
    public void approveChangingContactDetails() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForContactDetails();
        if(result.get()==ButtonType.OK){
            enableEditCDTextField();
        }
    }


    public void saveChangesInContactDetails() {

        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setCountryCD(countryCDTextField.getText());
        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setVoivodeshipCD(voivodeshipCDTextField.getText());
        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setCityCD(cityCDTextField.getText());
        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setStreetCD(streetCDTextField.getText());
        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setBuildingNumberCD(buildingNoCDTextField.getText());
        ClientsDatabase.getInstance().get(getClientKey()).getContactDetails().setFlatNumberCD(flatNoCDTextField.getText());

        fileManager.writeDatabaseToFile();
        disableEditCDTextFields();
    }

    @FXML
    public void approveChangesInContactDetails() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForContactDetails();
        if(result.get() == ButtonType.OK) {
           saveChangesInContactDetails();
        }else {
            disableEditCDTextFields();
        }

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
