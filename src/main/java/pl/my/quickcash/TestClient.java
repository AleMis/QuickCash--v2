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


    private static void createClient2() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String login = "test2";
        String orginalPassword = "321";
        String securedPassword = SecurePassword.generateStrongPasswordHash(orginalPassword);
        ClientKey clientKey = new ClientKey(login,securedPassword);
        CommunicationDAO.insert(INSERT_CLIENT_KEY, clientKey);

        ClientKey client = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, login);

        String firstName = "Adam";
        String lastName = "Kowalski";
        String pesel = "90011144321";
        String id_Card = "APR11111";
        String country = "Poland";
        String voivodeship = "Dolnośląskie";
        String city = "Wrocław";
        String street = "Sokola";
        String buildingNumber = "12";
        String flatNumber = "4";
        BigInteger client_key_id = client.getClient_key_id();

        ClientPersonalData clientPersonalData = new ClientPersonalData(firstName, lastName, pesel, id_Card, country, voivodeship, city, street, buildingNumber, flatNumber, client_key_id);

        String country_CD = "Poland";
        String voivodeship_CD = "Mazowieckie";
        String city_CD = "Warszawa";
        String street_CD = "Ujazdowska";
        String buildingNumber_CD = "22";
        String flatNumber_CD = "2";

        ClientContactDetails clientContactDetails = new ClientContactDetails(country_CD, voivodeship_CD, city_CD, street_CD, buildingNumber_CD, flatNumber_CD, client_key_id);

        BigDecimal accountBalance = new BigDecimal("10000.00");
        String accountNumber = "12345";

        ClientAccount clientAccount = new ClientAccount(accountBalance, accountNumber, client_key_id);

        CommunicationDAO.insert(INSERT_CLIENT_PERSONAL_DATA, clientPersonalData);
        CommunicationDAO.insert(INSERT_CLIENT_CONTACT_DETAILS, clientContactDetails);
        CommunicationDAO.insert(INSERT_CLIENT_ACCOUNT, clientAccount);
    }
}

