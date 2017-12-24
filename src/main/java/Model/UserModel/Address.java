package Model.UserModel;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
