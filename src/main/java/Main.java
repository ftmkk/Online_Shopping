import Controller.Filter.FilterByBrand;
import Controller.Filter.FilterByCategory;
import Controller.Filter.FilterProducts;
import Controller.DataController.*;
import Controller.Sort.SortByPrice;
import Controller.Sort.SortProducts;
import Model.ProductModel.*;
import Model.UserModel.Address;
import Model.UserModel.Gender;
import Model.UserModel.ProductInBasket;
import Model.UserModel.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {

        List<Attribute> attrL1 = new ArrayList<>();
        List<Attribute> attrL2 = new ArrayList<>();
        List<Attribute> attrL3 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        List<Color> colors2 = new ArrayList<>();
        List<Color> colors3 = new ArrayList<>();
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


        Product p3 = new Product(
                "p3",
                "P3",
                20000000L,
                ProductStatus.UNAVAILABLE,
                4,
                "THis is product p3",
                91992,
                93,
                null,
                "THis is review of product p3!",
                new Brand("Apple","appel"),
                attrL3,
                colors3,
                new Guaranty("6 months MICROTELL"),
                3000L);


        IProductController pr = new ProductController();
        pr.addProduct(p1);
        pr.addProduct(p2);
        pr.addProduct(p3);

        Category categoryA = new Category("a","a");
        Category categoryB = new Category("b","b");
        Category categoryC = new Category("c","c");


        Product pr1 = pr.getProductByName("p1");
        Product pr2 = pr.getProductByName("p2");
        Product pr3 = pr.getProductByName("p3");

        ICategoryController cr = new CategoryController();

        cr.addCategory(categoryA);
        cr.addCategory(categoryB);
        cr.addCategory(categoryC);

        Category catA = cr.getCategoryByName("a");
        Category catB = cr.getCategoryByName("b");
        Category catC = cr.getCategoryByName("c");

        cr.addProductToCategory(pr1,catC);
        cr.addProductToCategory(pr2,catC);
        cr.addProductToCategory(pr3,catB);
        cr.addCategoryToCategory(catB,catA);
        cr.addCategoryToCategory(catC,catA);


        logger.info("success session");

        FilterProducts fp = new FilterByCategory(catA);
        List<Product> faltered = fp.filter();
        SortProducts sp = new SortByPrice(faltered,false);
        List<Product> sortedList= sp.sort();
        for(Product p : sortedList){
            System.out.println(p.toString());
        }

        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand("Samsung","SAMSUNG"));
        FilterProducts fp2 = new FilterByBrand(fp, brandList);

        System.out.println(fp2.filter());


        IUserController ur = new UserController();

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
        ur.addToWishListOfUser(user,pr1);

        System.out.println(pr1.getColors());
        ProductInBasket productInBasket = new ProductInBasket(pr1,2, null);
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

        System.out.println(user.getOrderList());
    }
}

