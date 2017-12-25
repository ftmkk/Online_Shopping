package Model.UserModel;

import Model.Hibernate;
import Model.ProductModel.Content;
import Model.ProductModel.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
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


    public User(String username, String password, String phoneNumber, String mobileNumber, String email, Gender gender, String residenceAddress, Date birthDate) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.residenceAddress = residenceAddress;
        this.birthDate = birthDate;
        this.addresses = new ArrayList<>();
        this.wishList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.basketList = new ArrayList<>();
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<OrderPackage> getOrderList() {
        return orderList;
    }

    public List<Product> getWishList() {
        return wishList;
    }

    public List<ProductInBasket> getBasketList() {
        return basketList;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBasketList(List<ProductInBasket> basketList) {
        this.basketList = basketList;
    }


    public boolean addIfNotExistUsername(){
        String key = "username";
        String value = this.getUsername();
        boolean result = Hibernate.addIfNotExist(this,key,value);
        User u = (User) Hibernate.getByKey(this.getClass(),key,value);
        this.setId(u.getId());
        return result;
    }


    public static User getByUsername(String username){
        return (User) Hibernate.getByKey(User.class, "username",username);
    }

    public boolean hasProductInWishList(Product product){
        for(Product productInWishList : this.getWishList()){
            if(productInWishList.getName().equals(product.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean hasProductInBasket(ProductInBasket productInBasket){
        for(ProductInBasket currentProductInBasket : this.getBasketList()){
            if(currentProductInBasket.getProduct().getName().equals(productInBasket.getProduct().getName())){
                return true;
            }
        }
        return false;
    }

    public boolean addProductToWishListIfNotExist(Product product){
        if(!hasProductInWishList(product)){
            this.getWishList().add(product);
            Hibernate.update(this);
            return true;
        }
        Hibernate.update(this);
        return false;
    }

    public boolean addProductInBasketIfNotExist(ProductInBasket productInBasket){
        if(!hasProductInBasket(productInBasket)){
            this.getBasketList().add(productInBasket);
            Hibernate.update(this);
            return true;
        }
        Hibernate.update(this);
        return false;
    }

    public void clearBasket(){
        this.setBasketList(new ArrayList<>());
        Hibernate.update(this);
    }

    public void addOrderPackage(OrderPackage orderPackage){
        this.getOrderList().add(orderPackage);
        Hibernate.update(this);
    }

    public void addAddress(Address address){
        this.getAddresses().add(address);
        Hibernate.update(this);
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
