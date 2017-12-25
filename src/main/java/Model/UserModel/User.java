package Model.UserModel;

import Model.ProductModel.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

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
    private List<OrderPackage> orderList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<Product> wishList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<ProductInBasket> basketList;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<Address> addresses;

    public User(String name, String phoneNumber, String mobileNumber, String email, Gender gender, String residenceAddress, Date birthDate, List<OrderPackage> orderList, List<Product> wishList, List<ProductInBasket> basketList, List<Address> addresses) {
        this.name = name;
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

}
