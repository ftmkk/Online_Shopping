package Model.UserModel;

import Model.ProductModel.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String mobileNumber;

    @Column
    private String email;

    @Column
    @Enumerated
    private Gender gender;

    @Column
    private String residenceAddress;

    @Column
    private Date birthDate;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderPackage> orderList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> wishList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductInBasket> basketList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Address> addresses;

    public User(String username, String password, String phoneNumber, String mobileNumber, String email, Gender gender, String residenceAddress, Date birthDate, List<OrderPackage> orderList, List<Product> wishList, List<ProductInBasket> basketList, List<Address> addresses) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.residenceAddress = residenceAddress;
        this.birthDate = birthDate;
        this.orderList = orderList;
        this.wishList = wishList;
        this.basketList = basketList;
        this.addresses = addresses;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", birthDate=" + birthDate +
                ", orderList=" + orderList +
                ", wishList=" + wishList +
                ", basketList=" + basketList +
                ", addresses=" + addresses +
                '}';
    }
}
