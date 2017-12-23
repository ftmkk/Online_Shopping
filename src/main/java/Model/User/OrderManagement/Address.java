package Model.User.OrderManagement;

public class Address {

    private String name;
    private String province;
    private String city;
    private String address;
    private Long postalCode;
    private String phoneNumber;
    private String mobileNumber;
    private Float lat;
    private Float lon;

    public Address(String name, String province, String city, String address, Long postalCode, String phoneNumber, String mobileNumber, Float lat, Float lon) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }
}
