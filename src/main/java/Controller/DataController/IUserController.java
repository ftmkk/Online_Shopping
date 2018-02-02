package Controller.DataController;

import Model.ProductModel.ProductInfo.Product;
import Model.ProductSpec.Product;
import Model.UserModel.UserInfo.Address;
import Model.UserModel.Order.ProductInBasket;
import Model.UserModel.UserInfo.User;

public interface IUserController {

    boolean addUser(User user);
    User getUserByUsername(String username);
    boolean addToBasketOfUser(User user, ProductInBasket productInBasket);
    boolean addToWishListOfUser(User user, Product product);
    void orderFromUser(User user, Address address);

}
