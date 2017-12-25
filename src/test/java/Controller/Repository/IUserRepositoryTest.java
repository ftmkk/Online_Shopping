package Controller.Repository;

import Controller.Filter.FilterByBrand;
import Controller.Filter.FilterByCategory;
import Controller.Filter.FilterProducts;
import Controller.Sort.SortByPrice;
import Controller.Sort.SortProducts;
import Model.ProductModel.*;
import Model.UserModel.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class IUserRepositoryTest extends TestCase {

    public void test_addUser_getUserByUsername() {
        IUserRepository ur = new UserRepository();

        User user = new User(
                "Fatemeh",
                "123123",
                "09129999999",
                "02177777777",
                "ftm.karimkhani@gmail.com",
                Gender.FEMALE,
                "Iran, Tehran, IUST, COMP",
                null);

        ur.addUser(user);
        User userExpected = User.getByUsername(user.getUsername());
        assertEquals(user.getId(),userExpected.getId());

    }

    public void test_addToBasketOfUser() {
        IUserRepository ur = new UserRepository();

        User user = new User(
                "Fatemeh",
                "123123",
                "09129999999",
                "02177777777",
                "ftm.karimkhani@gmail.com",
                Gender.FEMALE,
                "Iran, Tehran, IUST, COMP",
                null);

        ur.addUser(user);

        Product p1 = new Product(
                "p1",
                "P1",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p1!",
                91992,
                93,
                null,
                "THis is review of product p1!",
                new Brand("Samsung","SAMSUNG"),
                new ArrayList<>(),
                new ArrayList<>(),
                new Guaranty("12 months MICROTELL"),
                3000L);

        IProductRepository pr = new ProductRepository();
        pr.addProduct(p1);

        ProductInBasket p = new ProductInBasket(p1,2, null);
        ur.addToBasketOfUser(user,p);
        for(ProductInBasket productInBasket : user.getBasketList()){
            assertEquals(productInBasket,p);
        }
    }

    public void testAddToWishListOfUser() {
        IUserRepository ur = new UserRepository();

        User user = new User(
                "Fatemeh",
                "123123",
                "09129999999",
                "02177777777",
                "ftm.karimkhani@gmail.com",
                Gender.FEMALE,
                "Iran, Tehran, IUST, COMP",
                null);

        ur.addUser(user);

        Product p1 = new Product(
                "p1",
                "P1",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p1!",
                91992,
                93,
                null,
                "THis is review of product p1!",
                new Brand("Samsung","SAMSUNG"),
                new ArrayList<>(),
                new ArrayList<>(),
                new Guaranty("12 months MICROTELL"),
                3000L);

        IProductRepository pr = new ProductRepository();
        pr.addProduct(p1);

        ur.addToWishListOfUser(user,p1);
        for(Product product: user.getWishList()){
            assertEquals(product,p1);
        }
    }

    public void testOrderFromUser() {
        List<Attribute> attrL1 = new ArrayList<>();
        List<Attribute> attrL2 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        List<Color> colors2 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));


        Product p1 = new Product(
                "p1",
                "P1",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p1!",
                91992,
                93,
                null,
                "THis is review of product p1!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L);

        Product p2 = new Product(
                "p2",
                "P2",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p2!",
                91992,
                93,
                null,
                "THis is review of product p2!",
                new Brand("Sony","soni"),
                attrL2,
                colors2,
                new Guaranty("2 months MICROTELL"),
                3000L);


        IProductRepository pr = new ProductRepository();
        pr.addProduct(p1);
        pr.addProduct(p2);


        IUserRepository ur = new UserRepository();

        User user = new User(
                "Fatemeh",
                "123123",
                "09129999999",
                "02177777777",
                "ftm.karimkhani@gmail.com",
                Gender.FEMALE,
                "Iran, Tehran, IUST, COMP",
                null);

        ur.addUser(user);

        ProductInBasket productInBasket = new ProductInBasket(p1,2, null);
        ur.addToBasketOfUser(user,productInBasket);

        Address destination = new Address(
                "ftmkk",
                "Tehran",
                "Tehran",
                "IUST COMP",
                29034902834L,
                "02199999999",
                "09129999999",
                null,
                null
        );

        ur.orderFromUser(user,destination);

        for(OrderPackage orderPackage : user.getOrderList()){
            assertEquals(orderPackage.getDestination(),destination);
        }
    }
}