import Controller.Filter.FilterByCategory;
import Controller.Filter.FilterProducts;
import Controller.Repository.CategoryRepository;
import Controller.Repository.ICategoryRepository;
import Controller.Repository.IProductRepository;
import Controller.Repository.ProductRepository;
import Model.ProductModel.*;

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


        IProductRepository pr = new ProductRepository();
        pr.addProduct(p1);
        pr.addProduct(p2);
        pr.addProduct(p3);

        Category categoryA = new Category("a","a");
        Category categoryB = new Category("b","b");
        Category categoryC = new Category("c","c");

        ICategoryRepository cr = new CategoryRepository();
        cr.addCategory(categoryA);
        cr.addCategory(categoryB);
        cr.addCategory(categoryC);
        cr.addProductToCategory(p1,categoryC);
        cr.addProductToCategory(p2,categoryC);
        cr.addProductToCategory(p3,categoryB);
        cr.addCategoryToCategory(categoryB,categoryA);
        cr.addCategoryToCategory(categoryC,categoryA);


        logger.info("success session");

        FilterProducts fp = new FilterByCategory(categoryA);
        System.out.println(fp.filter());
    }
}
