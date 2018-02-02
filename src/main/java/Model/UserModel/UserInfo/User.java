package Model.UserModel.UserInfo;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Product;
import Model.UserModel.Order.OrderPackage;
import Model.UserModel.Order.ProductInBasket;
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

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Profile profile;

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


    public User(String username, String password, Profile profile, List<OrderPackage> orderList, List<Product> wishList, List<ProductInBasket> basketList) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.orderList = orderList;
        this.wishList = wishList;
        this.basketList = basketList;
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


    public List<OrderPackage> getOrderList() {
        return orderList;
    }

    public List<Product> getWishList() {
        return wishList;
    }

    public List<ProductInBasket> getBasketList() {
        return basketList;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setOrderList(List<OrderPackage> orderList) {
        this.orderList = orderList;
    }

    public void setWishList(List<Product> wishList) {
        this.wishList = wishList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBasketList(List<ProductInBasket> basketList) {
        this.basketList = basketList;
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



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", orderList=" + orderList +
                ", wishList=" + wishList +
                ", basketList=" + basketList +
                '}';
    }
}
