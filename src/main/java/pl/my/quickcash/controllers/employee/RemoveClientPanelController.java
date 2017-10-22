package pl.my.quickcash.controllers.employee;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientPersonalData;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

public class RemoveClientPanelController {

    private static final String SEARCH_BY_PESEL = "ClientPersonalData.selectClientByPesel";
    private static final String DELETE_CLIENT_PERSONAL_DATA = "ClientPersonalData.deleteClientPersonalData";
    private static final String DELETE_CLIENT_CONTACT_DETAILS = "ClientContactDetails.deleteClientContactDetails";
    private static final String DELETE_CLIENT_ACCOUNT = "ClientAccount.deleteClientAccount";
    private static final String DELETE_CLIENT_KEY = "ClientKey.deleteClientKey";

    @FXML private TextField searchField;
    @FXML private TextField firstNameField;

    @FXML private TextField lastNameField;
    @FXML private TextField peselField;
    @FXML private TextField idCardField;
    @FXML private TextField countryField;
    @FXML private TextField voivodeshipField;
    @FXML private TextField cityField;
    @FXML private TextField streetField;
    @FXML private TextField buildingNoField;
    @FXML private TextField flatNoField;


    @FXML
    public void initializeSearch() {
        if(searchField.getText() == null) {
            DialogUtils.dialogSearchClientEmptyField();
        }else if (!(searchField.getText().length() == 11)) {
            DialogUtils.dialogSearchClientPeselToShort();
        }else {
            try {
                ClientPersonalData clientPersonalData = search();
                setFieldsWithClientData(clientPersonalData);
            }catch (NullPointerException e) {
                System.out.println(e);
                DialogUtils.dialogNoClientFound();
            }
        }
    }

    @FXML
    public void removeClient() {
        ClientPersonalData clientPersonalData = null;
        try {
            clientPersonalData = search();
        }catch (NullPointerException e) {
            System.out.println();
        }

        if(searchField.getText() == null) {
            DialogUtils.dialogSearchClientEmptyField();
        }else if (!(searchField.getText().length() == 11)) {
            DialogUtils.dialogSearchClientPeselToShort();
        }else if (clientPersonalData == null) {
            DialogUtils.dialogNoClientFound();
        }else {
            Optional<ButtonType> result = DialogUtils.confirmationDialogRemoveClient();
            if(result.get() == ButtonType.OK) {
                clearFields();
                remove(clientPersonalData);
            }
        }

    }

    private void setFieldsWithClientData(ClientPersonalData clientPersonalData) {
        firstNameField.setText(clientPersonalData.getFirstName());
        lastNameField.setText(clientPersonalData.getLastName());
        peselField.setText(clientPersonalData.getPesel());
        idCardField.setText(clientPersonalData.getIdCard());
        countryField.setText(clientPersonalData.getCountry());
        voivodeshipField.setText(clientPersonalData.getVoivodeship());
        cityField.setText(clientPersonalData.getCity());
        streetField.setText(clientPersonalData.getStreet());
        buildingNoField.setText(clientPersonalData.getBuildingNumber());
        flatNoField.setText(clientPersonalData.getFlatNumber());
    }

    private ClientPersonalData search() {
       String string = searchField.getText();
       ClientPersonalData clientPersonalData = CommunicationDAO.selectByString(SEARCH_BY_PESEL, string);
       return clientPersonalData;
    }

    public void disableFields() {
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        peselField.setEditable(false);
        idCardField.setEditable(false);
        countryField.setEditable(false);
        voivodeshipField.setEditable(false);
        cityField.setEditable(false);
        streetField.setEditable(false);
        buildingNoField.setEditable(false);
        flatNoField.setEditable(false);
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        peselField.clear();
        idCardField.clear();
        countryField.clear();
        voivodeshipField.clear();
        cityField.clear();
        streetField.clear();
        buildingNoField.clear();
        flatNoField.clear();
    }

    private void remove(ClientPersonalData clientPersonalData) {
        CommunicationDAO.deleteByID(DELETE_CLIENT_PERSONAL_DATA, clientPersonalData.getClient_key_id());
        CommunicationDAO.deleteByID(DELETE_CLIENT_CONTACT_DETAILS, clientPersonalData.getClient_key_id());
        CommunicationDAO.deleteByID(DELETE_CLIENT_ACCOUNT, clientPersonalData.getClient_key_id());
        CommunicationDAO.deleteByID(DELETE_CLIENT_KEY, clientPersonalData.getClient_key_id());
    }
}
