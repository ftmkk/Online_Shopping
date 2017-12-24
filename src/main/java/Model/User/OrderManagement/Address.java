package Model.User.OrderManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private String name;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String address;
    @Column
    private Long postalCode;
    @Column
    private String phoneNumber;
    @Column
    private String mobileNumber;
    @Column
    private Float lat;
    @Column
    private Float lon;

    public Address(Integer id, String name, String province, String city, String address, Long postalCode, String phoneNumber, String mobileNumber, Float lat, Float lon) {
        this.id = id;
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

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public void setLon(Float lon) {
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
