package pl.my.quickcash;


import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.password_security.SecurePassword;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestClient {

    private static final String INSERT_CLIENT_KEY = "ClientKey.insertClientKey";
    private static final String GET_CLIENT_KEY_BY_LOGIN = "ClientKey.selectClientKey";
    private static final String INSERT_CLIENT_ACCOUNT = "ClientAccount.insertClientAccount";
    private static final String INSERT_CLIENT_CONTACT_DETAILS = "ClientContactDetails.insertClientContactDetails";
    private static final String INSERT_CLIENT_PERSONAL_DATA = "ClientPersonalData.insertClientPersonalData";

    public static void createTestClients() throws InvalidKeySpecException, NoSuchAlgorithmException {

        ClientKey client1 = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, "test");
        ClientKey client2 = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, "test2");

        if (client1 == null && client2 == null) {
            createClient1();
            createClient2();
        } else if ((client1 == null) && !(client2 == null)) {
            createClient1();
        } else if (!(client1 == null) && (client2 == null)) {
            createClient2();
        }
    }

    private static void createClient2() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String login2 = "test2";
        String orginalPassword2 = "321";
        String securedPassword2 = SecurePassword.generateStrongPasswordHash(orginalPassword2);
        ClientKey clientKey2 = new ClientKey(login2,securedPassword2);
        CommunicationDAO.insert(INSERT_CLIENT_KEY, clientKey2);

        ClientKey client2 = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, login2);

        String firstName2 = "Adam";
        String lastName2 = "Kowalski";
        String pesel2 = "90011144321";
        String id_Card2 = "APR11111";
        String country2 = "Poland";
        String voivodeship2 = "Dolnośląskie";
        String city2 = "Wrocław";
        String street2 = "Sokola";
        String buildingNumber2 = "12";
        String flatNumber2 = "4";
        BigInteger client_key_id2 = client2.getClient_key_id();

        ClientPersonalData clientPersonalData2 = new ClientPersonalData(firstName2, lastName2, pesel2, id_Card2, country2, voivodeship2, city2, street2, buildingNumber2, flatNumber2, client_key_id2);

        String country_CD2 = "Poland";
        String voivodeship_CD2 = "Mazowieckie";
        String city_CD2 = "Warszawa";
        String street_CD2 = "Ujazdowska";
        String buildingNumber_CD2 = "22";
        String flatNumber_CD2 = "2";

        ClientContactDetails clientContactDetails2 = new ClientContactDetails(country_CD2, voivodeship_CD2, city_CD2, street_CD2, buildingNumber_CD2, flatNumber_CD2, client_key_id2);

        BigDecimal accountBalance2 = new BigDecimal("10000.00");
        String accountNumber2 = "12345";

        ClientAccount clientAccount2 = new ClientAccount(accountBalance2, accountNumber2, client_key_id2);

        CommunicationDAO.insert(INSERT_CLIENT_PERSONAL_DATA, clientPersonalData2);
        CommunicationDAO.insert(INSERT_CLIENT_CONTACT_DETAILS, clientContactDetails2);
        CommunicationDAO.insert(INSERT_CLIENT_ACCOUNT, clientAccount2);
    }

    private static void createClient1() throws InvalidKeySpecException, NoSuchAlgorithmException {

        String login = "test";
        String orginalPassword = "123";
        String securedPassword = SecurePassword.generateStrongPasswordHash(orginalPassword);
        ClientKey clientKey = new ClientKey(login,securedPassword);
        CommunicationDAO.insert(INSERT_CLIENT_KEY, clientKey);

        ClientKey client = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, login);

        String firstName = "Jan";
        String lastName = "Nowak";
        String pesel = "99003111312";
        String id_Card = "APR00000";
        String country = "Poland";
        String voivodeship = "Mazowieckie";
        String city = "Warszawa";
        String street = "Ujazdowska";
        String buildingNumber = "22";
        String flatNumber = "2";
        BigInteger client_key_id = client.getClient_key_id();

        ClientPersonalData clientPersonalData = new ClientPersonalData(firstName,lastName,pesel,id_Card,country,voivodeship,city,street,buildingNumber,flatNumber,client_key_id);

        String country_CD = "Poland";
        String voivodeship_CD = "Mazowieckie";
        String city_CD = "Warszawa";
        String street_CD = "Ujazdowska";
        String buildingNumber_CD = "22";
        String flatNumber_CD = "2";

        ClientContactDetails clientContactDetails = new ClientContactDetails(country_CD, voivodeship_CD, city_CD, street_CD,buildingNumber_CD,flatNumber_CD,client_key_id);

        BigDecimal accountBalance = new BigDecimal("20000.00");
        String accountNumber = "54321";

        ClientAccount clientAccount = new ClientAccount(accountBalance, accountNumber, client_key_id);

        CommunicationDAO.insert(INSERT_CLIENT_PERSONAL_DATA, clientPersonalData);
        CommunicationDAO.insert(INSERT_CLIENT_CONTACT_DETAILS, clientContactDetails);
        CommunicationDAO.insert(INSERT_CLIENT_ACCOUNT, clientAccount);
    }
}

