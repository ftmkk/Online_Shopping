package Controller.DataController;

import Model.Entities.ProductInfo.Product;
import Model.Entities.UserInfo.Address;
import Model.Entities.Order.ProductInBasket;
import Model.Entities.UserInfo.User;

public interface IUserController {

    boolean addUser(User user);
    User getUserByUsername(String username);
    boolean addToBasketOfUser(User user, ProductInBasket productInBasket);
    boolean addToWishListOfUser(User user, Product product);
    void orderFromUser(User user, Address address);

}
