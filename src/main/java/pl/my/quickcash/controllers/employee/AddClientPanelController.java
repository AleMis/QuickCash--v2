package pl.my.quickcash.controllers.employee;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.ClientPersonalData;
import pl.my.quickcash.data.EmployeeKey;

public class AddClientPanelController {

    private EmployeeKey employeeKey;

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    private void initialize() {

    }

    @FXML
    private Button addClientButton;

    @FXML
    private Button clearFieldsButton;

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



    public void addNewClient() {




    }

    public void readPersonalInformation() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String pesel = peselTextField.getText();
        String idcard = idNumberTextField.getText();
        String country = countryTextField.getText();
        String voivodeship = voivodeshipTextField.getText();
        String city = cityTextField.getText();
        String street = streetTextField.getText();
        String buildingNo = buildingNoTextField.getText();
        String flatNo = flatNoTextField.getText();

        ClientPersonalData clientPersonalData = new ClientPersonalData(firstName, lastName, pesel, idcard, country,
                                                                        voivodeship,city,street,buildingNo,flatNo);
    }

    public void readContactDetailsInformation(){

    }
}
