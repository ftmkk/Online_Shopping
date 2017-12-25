package Controller.Repository;

import Model.ProductModel.Product;
import Model.UserModel.Address;
import Model.UserModel.ProductInBasket;
import Model.UserModel.User;

public interface IUserRepository {

    boolean addUser(User user);
    boolean addToBasketOfUser(User user, ProductInBasket productInBasket);
    boolean addToWishListOfUser(User user, Product product);
    void orderFromUser(User user, Address address);

}
