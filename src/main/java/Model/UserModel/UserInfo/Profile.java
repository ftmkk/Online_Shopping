package Model.UserModel.UserInfo;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column
    private String phoneNumber;

    @Column
    private String mobileNumber;

    @Column
    private String emailAddress;

    @Column
    private Gender gender;

    @Column
    private Date birthDate;

    @Column
    private String residenceAddress;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Address> addressList;


    public Profile(String phoneNumber, String mobileNumber, String emailAddress, Gender gender, Date birthDate, String residenceAddress, List<Address> addressList) {
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this.birthDate = birthDate;
        this.residenceAddress = residenceAddress;
        this.addressList = addressList;
    }

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public Profile() {
    }
}
