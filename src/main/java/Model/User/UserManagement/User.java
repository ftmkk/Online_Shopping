package Model.User.UserManagement;

import Model.Product.ProductManagement.Product;
import Model.User.OrderManagement.Address;
import Model.User.OrderManagement.Order;
import Model.User.OrderManagement.SelectedProduct;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(generator = "increament")
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
    @OneToMany
    private List<Order> orderList;
    @Column
    @OneToMany
    private List<Product> wishList;
    @Column
    @OneToMany
    private List<SelectedProduct> currentBasket;
    @Column
    @OneToMany
    private List<Address> addresses;

    public User(Integer id, String name, String phoneNumber, String mobileNumber, String email, Gender gender, String residenceAddress, Date birthDate, List<Order> orderList, List<Product> wishList, List<SelectedProduct> currentBasket, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.residenceAddress = residenceAddress;
        this.birthDate = birthDate;
        this.orderList = orderList;
        this.wishList = wishList;
        this.currentBasket = currentBasket;
        this.addresses = addresses;
    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Product> getWishList() {
        return wishList;
    }

    public void setWishList(List<Product> wishList) {
        this.wishList = wishList;
    }

    public List<SelectedProduct> getCurrentBasket() {
        return currentBasket;
    }

    public void setCurrentBasket(List<SelectedProduct> currentBasket) {
        this.currentBasket = currentBasket;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
