package Controller.DataController;

import Model.ProductSpec.Product;
import Model.UserInfo.Address;
import Model.Order.ProductInBasket;
import Model.UserInfo.User;

public interface IUserController {

    boolean addUser(User user);
    User getUserByUsername(String username);
    boolean addToBasketOfUser(User user, ProductInBasket productInBasket);
    boolean addToWishListOfUser(User user, Product product);
    void orderFromUser(User user, Address address);

}
