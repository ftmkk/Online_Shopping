package Controller.DataController;

import Model.ProductModel.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class IProductControllerTest extends TestCase {

    public void test_addProduct_getProductById() {
        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));


        Product p1 = new Product(
                "p111",
                "P11",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p11!",
                91992,
                93,
                null,
                "THis is review of product p11!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L);

        IProductController pr = new ProductController();
        pr.addProduct(p1);

        Product pr1_byId = pr.getProductById(p1.getId());
        assertSame(pr1_byId.getId(),p1.getId());
    }


    public void test_addProduct_getProductByName() {
        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
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

        IProductController pr = new ProductController();
        pr.addProduct(p1);

        Product pr1_byName = pr.getProductByName(p1.getName());
        assertEquals(pr1_byName.getId(),p1.getId());
    }

    public void test_getProducts() {

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

        assertEquals(pr.getProducts().size(),3);

    }
}