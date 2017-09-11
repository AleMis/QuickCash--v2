package pl.my.quickcash.data;

public class ClientPersonalData {
    private String firstName;
    private String lastName;
    private String pesel;
    private String idCard;
    private String country;
    private String voivodeship;
    private String city;
    private String street;
    private String buildingNumber;
    private String flatNumber;

    public ClientPersonalData(String firstName, String lastName, String pesel, String idCard, String country, String voivodeship, String city, String street, String buildingNumber, String flatNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.idCard = idCard;
        this.country = country;
        this.voivodeship = voivodeship;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {

        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {

        this.flatNumber = flatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientPersonalData)) return false;

        ClientPersonalData that = (ClientPersonalData) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!pesel.equals(that.pesel)) return false;
        if (!idCard.equals(that.idCard)) return false;
        if (!country.equals(that.country)) return false;
        if (!voivodeship.equals(that.voivodeship)) return false;
        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        if (!buildingNumber.equals(that.buildingNumber)) return false;
        return flatNumber.equals(that.flatNumber);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + pesel.hashCode();
        result = 31 * result + idCard.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + voivodeship.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + buildingNumber.hashCode();
        result = 31 * result + flatNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(firstName);
        print.append("; ");
        print.append(lastName);
        print.append("; ");
        print.append(pesel);
        print.append("; ");
        print.append(idCard);
        print.append("; ");
        print.append(country);
        print.append("; ");
        print.append(voivodeship);
        print.append("; ");
        print.append(city);
        print.append("; ");
        print.append(street);
        print.append("; ");
        print.append(buildingNumber);
        print.append("; ");
        print.append(flatNumber);
        print.append("; ");
        return print.toString();
    }

}
