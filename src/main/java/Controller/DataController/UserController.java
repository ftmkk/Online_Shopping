package Controller.DataController;

import Model.Entities.ProductInfo.Product;
import Model.Repository.ProfileRepository;
import Model.Repository.UserRepository;
import Model.Entities.UserInfo.Address;
import Model.Entities.UserInfo.User;
import Model.Entities.Order.*;

import java.util.ArrayList;
import java.util.List;

public class UserController implements IUserController {
    @Override
    public boolean addUser(User user) {
        return UserRepository.addIfNotExistUsername(user);
    }


    @Override
    public User getUserByUsername(String username) {
        return UserRepository.getByUsername(username);
    }

    @Override
    public boolean addToBasketOfUser(User user, ProductInBasket productInBasket) {
        if(productInBasket.getProduct().getRemainingCount() >= productInBasket.getCount()){
            return UserRepository.addProductInBasketIfNotExist(user, productInBasket);
        }
        return false;
    }

    @Override
    public boolean removeFromBasketOfUser(User user, ProductInBasket productInBasket) {
        return UserRepository.removeProductFromBasketIfExist(user, productInBasket);
    }

    @Override
    public boolean addToWishListOfUser(User user, Product product) {
        return UserRepository.addProductToWishListIfNotExist(user, product);
    }

    @Override
    public boolean removeFromWishListOfUser(User user, Product product) {
        return UserRepository.removeProductFromWishListIfExist(user, product);
    }

    @Override
    public void orderFromUser(User user, Address destination) {
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        Long amount = 0L;
        for(ProductInBasket productInBasket : user.getBasketList()){


            OrderedProduct orderedProduct = new OrderedProduct(productInBasket);
            orderedProduct.setColor(productInBasket.getColor());
            orderedProduct.setCount(productInBasket.getCount());
            Long unitPrice = productInBasket.getProduct().getPrice() - productInBasket.getProduct().getDiscount();
            Long price = productInBasket.getCount() * unitPrice;
            orderedProduct.setTotalPrice(price);
            amount += price;

            orderedProducts.add(orderedProduct);
        }

        OrderPackage orderPackage = new OrderPackage(
                null,
                amount,
                orderedProducts,
                OrderStatus.UNPAID,
                0L,destination
        );

        UserRepository.clearBasket(user);
        ProfileRepository.addAddress(user.getProfile(), destination);
        UserRepository.addOrderPackage(user, orderPackage);

    }
}
