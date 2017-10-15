package pl.my.quickcash.controllers.employee;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.data.employee.EmployeeKey;
import pl.my.quickcash.datamanagement.FileManager;
import pl.my.quickcash.dialogs.DialogUtils;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

public class AddClientPanelController {

    private EmployeeKey employeeKey;
    private FileManager fileManager = new FileManager();
    private Random theGenerator = new Random();

    private ClientPersonalData clientPersonalData;
    private ClientContactDetails clientContactDetails;
    private ClientKey clientKey;
    private ClientAccount clientAccount;
    private ClientData newClient;

    public ClientData getNewClient() {
        return newClient;
    }

    public void setNewClient(ClientData newClient) {
        this.newClient = newClient;
    }

    public ClientContactDetails getClientContactDetails() {
        return clientContactDetails;
    }

    public void setClientContactDetails(ClientContactDetails clientContactDetails) {
        this.clientContactDetails = clientContactDetails;
    }

    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    private void initialize() {

    }
    //personal information text fields
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
    //contact details text fields
    @FXML private TextField countryCDTextField;
    @FXML private TextField cityCDTextField;
    @FXML private TextField buildingNoCDTextField;
    @FXML private TextField voivodeshipCDTextField;
    @FXML private TextField streetCDTextField;
    @FXML private TextField flatNoCDTextField;

    //account details text fields
    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private TextField accountBalanceTextField;
    @FXML private TextField accountNumberTextField;

    @FXML private CheckBox copyContactDetailsCheckBox;

    @FXML private Button changePasswordButton;
    @FXML private Button clearFieldsButton;


    @FXML
    public void addNewClient() {
        if(!validationOfPersonalInformationTextFields()) {
            DialogUtils.dialogCheckPersonalInformation();
        }else if (!validationOfContactDetailsTextFields()) {
            DialogUtils.dialogCheckContactDetails();
        }else if (validationOfPersonalInformationTextFields() && validationOfContactDetailsTextFields()) {
            Optional<ButtonType> result = DialogUtils.confirmationDialogForAddingNewClient();
            if(result.get() == ButtonType.OK) {
                newClient = createNewClient();
                ClientsDatabase.getInstance().put(clientKey, newClient);
                fileManager.writeDatabaseToFile();
            }
        }
    }


    @FXML
    public void setContactDetails() {
        if (copyContactDetailsCheckBox.isSelected()) {
            if (!validationOfPersonalInformationTextFields()) {
                DialogUtils.dialogCheckPersonalInformation();
                copyContactDetailsCheckBox.setSelected(false);
            } else  {
                disableContactDetailsTextFields();
                ClientPersonalData clientPersonalData = readPersonalInformation();
                clientContactDetails = new ClientContactDetails(clientPersonalData.getCountry(),
                        clientPersonalData.getVoivodeship(),
                        clientPersonalData.getCity(),
                        clientPersonalData.getStreet(),
                        clientPersonalData.getBuildingNumber(),
                        clientPersonalData.getFlatNumber(), 1);

                countryCDTextField.setText(clientPersonalData.getCountry());
                voivodeshipCDTextField.setText(clientPersonalData.getVoivodeship());
                cityCDTextField.setText(clientPersonalData.getCity());
                streetCDTextField.setText(clientPersonalData.getStreet());
                buildingNoCDTextField.setText(clientPersonalData.getBuildingNumber());
                flatNoCDTextField.setText(clientPersonalData.getFlatNumber());
            }
        }else {
            if(!copyContactDetailsCheckBox.isSelected()) {
                enableContactDetailsTextFields();
                clearContactDetailsFields();
            }
        }
    }

    @FXML
    public void generateClientAccountDetails() {

        if (!validationOfPersonalInformationTextFields()) {
            DialogUtils.dialogCheckPersonalInformation();
        } else {
            clientKey = createClientKey();
            generateNewClientAccount();

            loginTextField.setText(clientKey.getLogin());
            passwordTextField.setText(clientKey.getPassword());
            accountNumberTextField.setText(clientAccount.getAccountNumber());
            accountBalanceTextField.setText(String.valueOf(clientAccount.getAccountBalance()));
        }
    }



    public ClientPersonalData readPersonalInformation() {
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
        return clientPersonalData;
    }

    public ClientContactDetails readContactDetailsInformation(){
        String countryCD = countryCDTextField.getText();
        String cityCD = cityCDTextField.getText();
        String buildingCD = buildingNoCDTextField.getText();
        String voivodeshipCD = voivodeshipCDTextField.getText();
        String streetCD = streetCDTextField.getText();
        String flatNO = flatNoCDTextField.getText();

        ClientContactDetails clientContactDetails = new ClientContactDetails(countryCD,voivodeshipCD,cityCD,streetCD,
                buildingCD,flatNO, 1);

        return clientContactDetails;
    }

    public ClientData createNewClient() {
        ClientData newClient = new ClientData(readPersonalInformation(), getClientContactDetails(), getClientAccount());
        return newClient;
    }

    public void generateNewClientAccount() {
        String accountNumber = createAccountNumber();
        BigDecimal accountBalance = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_CEILING);
        clientAccount = new ClientAccount(accountBalance, accountNumber);
    }

    public void enablePersonalInformationTextFields() {
        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        peselTextField.setEditable(true);
        idNumberTextField.setEditable(true);
        countryTextField.setEditable(true);
        voivodeshipTextField.setEditable(true);
        cityTextField.setEditable(true);
        streetTextField.setEditable(true);
        buildingNoTextField.setEditable(true);
        flatNoTextField.setEditable(true);
    }

    public void disablePersonalInformationTextFields() {
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        peselTextField.setEditable(false);
        idNumberTextField.setEditable(false);
        countryTextField.setEditable(false);
        voivodeshipTextField.setEditable(false);
        cityTextField.setEditable(false);
        streetTextField.setEditable(false);
        buildingNoTextField.setEditable(false);
        flatNoTextField.setEditable(false);
    }

    public void enableContactDetailsTextFields() {
        countryCDTextField.setEditable(true);
        voivodeshipCDTextField.setEditable(true);
        cityCDTextField.setEditable(true);
        streetCDTextField.setEditable(true);
        flatNoCDTextField.setEditable(true);
        buildingNoCDTextField.setEditable(true);
    }

    public void disableContactDetailsTextFields() {
        countryCDTextField.setEditable(false);
        voivodeshipCDTextField.setEditable(false);
        cityCDTextField.setEditable(false);
        streetCDTextField.setEditable(false);
        flatNoCDTextField.setEditable(false);
        buildingNoCDTextField.setEditable(false);
    }

    public void disableClientAccountDetailsTextFields() {
        loginTextField.setEditable(false);
        passwordTextField.setEditable(false);
        accountNumberTextField.setEditable(false);
        accountBalanceTextField.setEditable(false);
    }

    private String createAccountNumber() {
        String number = "";
        String numbers = "0123456789";
        for (int i = 0; i < 5; i++) {
            number = number + "" + numbers.charAt(theGenerator.nextInt(numbers.length()));
        }
        return number;
    }

    public boolean validationOfPersonalInformationTextFields() {
        if(     !firstNameTextField.getText().trim().isEmpty() &&
                !lastNameTextField.getText().trim().isEmpty() &&
                !peselTextField.getText().trim().isEmpty() &&
                !idNumberTextField.getText().trim().isEmpty() &&
                !countryTextField.getText().trim().isEmpty() &&
                !voivodeshipTextField.getText().trim().isEmpty() &&
                !cityTextField.getText().trim().isEmpty() &&
                !streetTextField.getText().trim().isEmpty() &&
                !buildingNoTextField.getText().trim().isEmpty() &&
                !flatNoTextField.getText().trim().isEmpty() ) {
            return true;
        }else {
            return false;
        }
    }

    public boolean validationOfContactDetailsTextFields() {
        if(     !countryCDTextField.getText().trim().isEmpty() &&
                !voivodeshipCDTextField.getText().trim().isEmpty() &&
                !cityCDTextField.getText().trim().isEmpty() &&
                !streetCDTextField.getText().trim().isEmpty() &&
                !buildingNoCDTextField.getText().trim().isEmpty() &&
                !flatNoCDTextField.getText().trim().isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public ClientKey createClientKey() {
        ClientKey clientKey = new ClientKey(createClientLogin(), createClientPassword());
        return clientKey;
    }

    public String createClientLogin() {
        ClientPersonalData clientPersonalData = readPersonalInformation();
        String login = clientPersonalData.getLastName().substring(0,3) + ""
                     + clientPersonalData.getFirstName().substring(0, 3);
        return login;
    }

    public String createClientPassword() {
        String password = "";
        String alphabet = "123456789abcdefghijklmnoprstuwxyz";
        for (int i = 0; i < 7; i++) {
            password = password + "" + alphabet.charAt(theGenerator.nextInt(alphabet.length()));
        }
        return password;
    }


    public void clearContactDetailsFields() {
        countryCDTextField.clear();
        voivodeshipCDTextField.clear();
        cityCDTextField.clear();
        streetCDTextField.clear();
        buildingNoCDTextField.clear();
        flatNoCDTextField.clear();
    }







}
