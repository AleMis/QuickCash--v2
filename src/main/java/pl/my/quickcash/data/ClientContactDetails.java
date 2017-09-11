package pl.my.quickcash.data;

public class ClientContactDetails {

    private String countryCD;
    private String voivodeshipCD;
    private String cityCD;
    private String streetCD;
    private String buildingNumberCD;
    private String flatNumberCD;

    public ClientContactDetails(String countryCD, String voivodeshipCD, String cityCD, String streetCD, String buildingNumberCD, String flatNumberCD) {
        this.countryCD = countryCD;
        this.voivodeshipCD = voivodeshipCD;
        this.cityCD = cityCD;
        this.streetCD = streetCD;
        this.buildingNumberCD = buildingNumberCD;
        this.flatNumberCD = flatNumberCD;
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
        if (!(o instanceof ClientContactDetails)) return false;

        ClientContactDetails that = (ClientContactDetails) o;

        if (!getCountryCD().equals(that.getCountryCD())) return false;
        if (!getVoivodeshipCD().equals(that.getVoivodeshipCD())) return false;
        if (!getCityCD().equals(that.getCityCD())) return false;
        if (!getStreetCD().equals(that.getStreetCD())) return false;
        if (!getBuildingNumberCD().equals(that.getBuildingNumberCD())) return false;
        return getFlatNumberCD().equals(that.getFlatNumberCD());
    }

    @Override
    public int hashCode() {
        int result = getCountryCD().hashCode();
        result = 31 * result + getVoivodeshipCD().hashCode();
        result = 31 * result + getCityCD().hashCode();
        result = 31 * result + getStreetCD().hashCode();
        result = 31 * result + getBuildingNumberCD().hashCode();
        result = 31 * result + getFlatNumberCD().hashCode();
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

