package Controller.DataController;

import Model.ProductModel.Feedback.FeedbackManagement;
import Model.ProductModel.ProductInfo.*;
import Model.UserModel.Order.*;
import Model.UserModel.UserInfo.Address;
import Model.UserModel.UserInfo.Profile;
import Model.UserModel.UserInfo.User;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class IUserControllerTest extends TestCase {

    public void test_addUser_getUserByUsername() {
        IUserController ur = new UserController();

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        ur.addUser(user);
        User userExpected = ur.getUserByUsername(user.getUsername());
        assertEquals(user.getId(),userExpected.getId());

    }

    public void test_addToBasketOfUser() {
        IUserController ur = new UserController();

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

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
                3000L,
                new FeedbackManagement());

        IProductController pr = new ProductController();
        pr.addProduct(p1);

        ProductInBasket p = new ProductInBasket(p1,2, null);
        ur.addToBasketOfUser(user,p);
        for(ProductInBasket productInBasket : user.getBasketList()){
            assertEquals(productInBasket,p);
        }
    }

    public void testAddToWishListOfUser() {
        IUserController ur = new UserController();

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

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
                3000L,
                new FeedbackManagement());

        IProductController pr = new ProductController();
        pr.addProduct(p1);

        ur.addToWishListOfUser(user,p1);
        for(Product product: user.getWishList()){
            assertEquals(product,p1);
        }
    }

    public void test_orderFromUser() {
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
                3000L,
                new FeedbackManagement());

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
                3000L,
                new FeedbackManagement());


        IProductController pr = new ProductController();
        pr.addProduct(p1);
        pr.addProduct(p2);


        IUserController ur = new UserController();

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

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