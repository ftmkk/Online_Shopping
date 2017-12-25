package Controller.DataController;

import Model.ProductModel.Product;
import Model.UserModel.Address;
import Model.UserModel.ProductInBasket;
import Model.UserModel.User;

public interface IUserController {

    boolean addUser(User user);
    User getUserByUsername(String username);
    boolean addToBasketOfUser(User user, ProductInBasket productInBasket);
    boolean addToWishListOfUser(User user, Product product);
    void orderFromUser(User user, Address address);

}
