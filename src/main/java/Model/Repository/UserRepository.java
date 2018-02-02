package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Product;
import Model.UserModel.Order.OrderPackage;
import Model.UserModel.Order.ProductInBasket;
import Model.UserModel.UserInfo.User;

import java.util.ArrayList;

public class UserRepository {

    public static boolean addIfNotExistUsername(User user){
        String key = "username";
        String value = user.getUsername();
        boolean result = Hibernate.addIfNotExist(user,key,value);
        User u = (User) Hibernate.getByKey(user.getClass(),key,value);
        user.setId(u.getId());
        return result;
    }

    public static void addOrderPackage(User user, OrderPackage orderPackage){
        user.getOrderList().add(orderPackage);
        Hibernate.update(user);
    }


    public static boolean addProductInBasketIfNotExist(User user, ProductInBasket productInBasket){
        if(!user.hasProductInBasket(productInBasket)){
            user.getBasketList().add(productInBasket);
            Hibernate.update(user);
            return true;
        }
        Hibernate.update(user);
        return false;
    }

    public static boolean addProductToWishListIfNotExist(User user, Product product){
        if(!user.hasProductInWishList(product)){
            user.getWishList().add(product);
            Hibernate.update(user);
            return true;
        }
        Hibernate.update(user);
        return false;
    }


    public static void clearBasket(User user){
        user.setBasketList(new ArrayList<>());
        Hibernate.update(user);
    }

    public static User getByUsername(String username){
        return (User) Hibernate.getByKey(User.class, "username",username);
    }

}
