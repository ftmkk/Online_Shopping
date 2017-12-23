package Model.User.UserManagement;

import Model.Product.ProductManagement.Product;
import Model.User.OrderManagement.Address;
import Model.User.OrderManagement.Order;
import Model.User.OrderManagement.SelectedProduct;

import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private Gender gender;
    private String residenceAddress;
    private Date birthDate;
    private List<Order> orderList;
    private List<Product> wishList;
    private List<SelectedProduct> currentBasket;
    private List<Address> addresses;

}
