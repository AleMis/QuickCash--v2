package pl.my.quickcash.data.client;

import java.math.BigInteger;

public class ClientContactDetails {

    private String countryCD;
    private String voivodeshipCD;
    private String cityCD;
    private String streetCD;
    private String buildingNumberCD;
    private String flatNumberCD;
    private BigInteger client_key_id;

    public ClientContactDetails(String countryCD, String voivodeshipCD, String cityCD, String streetCD, String buildingNumberCD, String flatNumberCD, BigInteger client_key_id) {
        this.countryCD = countryCD;
        this.voivodeshipCD = voivodeshipCD;
        this.cityCD = cityCD;
        this.streetCD = streetCD;
        this.buildingNumberCD = buildingNumberCD;
        this.flatNumberCD = flatNumberCD;
        this.client_key_id = client_key_id;
    }


    public ClientContactDetails(String countryCD, String voivodeshipCD, String cityCD, String streetCD, String buildingNumberCD, String flatNumberCD) {
        this.countryCD = countryCD;
        this.voivodeshipCD = voivodeshipCD;
        this.cityCD = cityCD;
        this.streetCD = streetCD;
        this.buildingNumberCD = buildingNumberCD;
        this.flatNumberCD = flatNumberCD;
    }

    public BigInteger getClient_key_id() {
        return client_key_id;
    }

    public void setClient_key_id(BigInteger client_key_id) {
        this.client_key_id = client_key_id;
    }

    public String getCountryCD() {
        return countryCD;
    }

    public void setCountryCD(String countryCD) {
        this.countryCD = countryCD;
    }

    public String getVoivodeshipCD() {
        return voivodeshipCD;
    }

    public void setVoivodeshipCD(String voivodeshipCD) {
        this.voivodeshipCD = voivodeshipCD;
    }

    public String getCityCD() {
        return cityCD;
    }

    public void setCityCD(String cityCD) {
        this.cityCD = cityCD;
    }

    public String getStreetCD() {
        return streetCD;
    }

    public void setStreetCD(String streetCD) {
        this.streetCD = streetCD;
    }

    public String getBuildingNumberCD() {
        return buildingNumberCD;
    }

    public void setBuildingNumberCD(String buildingNumberCD) {
        this.buildingNumberCD = buildingNumberCD;
    }

    public String getFlatNumberCD() {
        return flatNumberCD;
    }

    public void setFlatNumberCD(String flatNumberCD) {
        this.flatNumberCD = flatNumberCD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientContactDetails that = (ClientContactDetails) o;

        if (!countryCD.equals(that.countryCD)) return false;
        if (!voivodeshipCD.equals(that.voivodeshipCD)) return false;
        if (!cityCD.equals(that.cityCD)) return false;
        if (!streetCD.equals(that.streetCD)) return false;
        if (!buildingNumberCD.equals(that.buildingNumberCD)) return false;
        if (!flatNumberCD.equals(that.flatNumberCD)) return false;
        return client_key_id.equals(that.client_key_id);
    }

    @Override
    public int hashCode() {
        int result = countryCD.hashCode();
        result = 31 * result + voivodeshipCD.hashCode();
        result = 31 * result + cityCD.hashCode();
        result = 31 * result + streetCD.hashCode();
        result = 31 * result + buildingNumberCD.hashCode();
        result = 31 * result + flatNumberCD.hashCode();
        result = 31 * result + client_key_id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);

        print.append(countryCD);
        print.append("; ");
        print.append(voivodeshipCD);
        print.append("; ");
        print.append(cityCD);
        print.append("; ");
        print.append(streetCD);
        print.append("; ");
        print.append(buildingNumberCD);
        print.append("; ");
        print.append(flatNumberCD);
        print.append("; ");
        return print.toString();
    }


}

