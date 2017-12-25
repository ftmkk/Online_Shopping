package Controller.Repository;

import Model.ProductModel.Product;
import Model.UserModel.*;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public boolean addUser(User user) {
        return user.addIfNotExistUsername();
    }

    @Override
    public boolean addToBasketOfUser(User user, ProductInBasket productInBasket) {
        if(productInBasket.getProduct().getRemainingCount() >= productInBasket.getCount()){
            return user.addProductInBasketIfNotExist(productInBasket);
        }
        return false;
    }

    @Override
    public boolean addToWishListOfUser(User user, Product product) {
        return user.addProductToWishListIfNotExist(product);
    }

    @Override
    public void orderFromUser(User user, Address destination) {
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        Long amount = 0L;
        for(ProductInBasket productInBasket : user.getBasketList()){


            OrderedProduct orderedProduct = new OrderedProduct(productInBasket.getProduct());
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

        user.clearBasket();
        user.addAddress(destination);
        user.addOrderPackage(orderPackage);

    }
}
