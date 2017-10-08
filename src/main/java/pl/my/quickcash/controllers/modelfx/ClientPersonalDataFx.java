package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.SimpleStringProperty;

public class ClientPersonalDataFx {

    private SimpleStringProperty firstName  = new SimpleStringProperty();
    private SimpleStringProperty lastName  = new SimpleStringProperty();
    private SimpleStringProperty pesel  = new SimpleStringProperty();
    private SimpleStringProperty idCard  = new SimpleStringProperty();
    private SimpleStringProperty country  = new SimpleStringProperty();
    private SimpleStringProperty voivodeship  = new SimpleStringProperty();
    private SimpleStringProperty city  = new SimpleStringProperty();
    private SimpleStringProperty street  = new SimpleStringProperty();
    private SimpleStringProperty buildingNumber  = new SimpleStringProperty();
    private SimpleStringProperty flatNumber  = new SimpleStringProperty();


    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPesel() {
        return pesel.get();
    }

    public SimpleStringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }

    public String getIdCard() {
        return idCard.get();
    }

    public SimpleStringProperty idCardProperty() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard.set(idCard);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getVoivodeship() {
        return voivodeship.get();
    }

    public SimpleStringProperty voivodeshipProperty() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship.set(voivodeship);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getBuildingNumber() {
        return buildingNumber.get();
    }

    public SimpleStringProperty buildingNumberProperty() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber.set(buildingNumber);
    }

    public String getFlatNumber() {
        return flatNumber.get();
    }

    public SimpleStringProperty flatNumberProperty() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber.set(flatNumber);
    }

    @Override
    public String toString() {
        return firstName + "" + lastName + "" + pesel + "" + idCard + "" + country + "" + voivodeship + "" + city +
                "" + street + "" + buildingNumber + "" + flatNumber;
    }
}
