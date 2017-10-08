package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.SimpleStringProperty;

public class ClientContactDetailsFx {

    private SimpleStringProperty countryCD = new SimpleStringProperty();
    private SimpleStringProperty voivodeshipCD = new SimpleStringProperty();
    private SimpleStringProperty cityCD = new SimpleStringProperty();
    private SimpleStringProperty streetCD = new SimpleStringProperty();
    private SimpleStringProperty buildingNumberCD = new SimpleStringProperty();
    private SimpleStringProperty flatNumberCD = new SimpleStringProperty();


    public String getCountryCD() {
        return countryCD.get();
    }

    public SimpleStringProperty countryCDProperty() {
        return countryCD;
    }

    public void setCountryCD(String countryCD) {
        this.countryCD.set(countryCD);
    }

    public String getVoivodeshipCD() {
        return voivodeshipCD.get();
    }

    public SimpleStringProperty voivodeshipCDProperty() {
        return voivodeshipCD;
    }

    public void setVoivodeshipCD(String voivodeshipCD) {
        this.voivodeshipCD.set(voivodeshipCD);
    }

    public String getCityCD() {
        return cityCD.get();
    }

    public SimpleStringProperty cityCDProperty() {
        return cityCD;
    }

    public void setCityCD(String cityCD) {
        this.cityCD.set(cityCD);
    }

    public String getStreetCD() {
        return streetCD.get();
    }

    public SimpleStringProperty streetCDProperty() {
        return streetCD;
    }

    public void setStreetCD(String streetCD) {
        this.streetCD.set(streetCD);
    }

    public String getBuildingNumberCD() {
        return buildingNumberCD.get();
    }

    public SimpleStringProperty buildingNumberCDProperty() {
        return buildingNumberCD;
    }

    public void setBuildingNumberCD(String buildingNumberCD) {
        this.buildingNumberCD.set(buildingNumberCD);
    }

    public String getFlatNumberCD() {
        return flatNumberCD.get();
    }

    public SimpleStringProperty flatNumberCDProperty() {
        return flatNumberCD;
    }

    public void setFlatNumberCD(String flatNumberCD) {
        this.flatNumberCD.set(flatNumberCD);
    }

    @Override
    public String toString() {
        return countryCD + "" + voivodeshipCD + "" + cityCD + "" + streetCD + "" + buildingNumberCD + "" + flatNumberCD;
    }
}
