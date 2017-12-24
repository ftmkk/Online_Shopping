import Controller.Product.FilterManagement.FilterByAttribute;
import Controller.Product.FilterManagement.FilterByCategory;
import Controller.Product.FilterManagement.FilterProducts;
import Model.Hibernate;
import Model.Product.AttributeManagement.Attribute;
import Model.Product.AttributeManagement.AttributeGroup;
import Model.Product.AttributeManagement.AttributeRepository;
import Model.Product.ProductManagement.*;
import org.hibernate.Session;
import org.w3c.dom.css.RGBColor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {

        AttributeRepository attrR = new AttributeRepository();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1");
        attrG.addAttribute(new Attribute(1, "ATTRIBUTE_A", "2"));
        attrG.addAttribute(new Attribute(2,"ATTRIBUTE_B","true"));
        attrR.addAttributeGroup(attrG);
        List<Color> colors = new ArrayList<>();
        colors.add(new Color(1, "RED", 3,3,3));



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
                new Brand(2, "Samsung","SAMSUNG"),
                attrR,
                colors,
                new Guaranty(1,"12 months MICROTELL"),
                3000L);

        Product p2 = new Product(
                "p2",
                "P2",
                30000000L,
                ProductStatus.UNAVAILABLE,
                5,
                "THis is product p2!",
                92342,
                2343,
                null,
                "THis is review of product p2!",
                new Brand(2, "Apple","APPLE"),
                attrR,
                colors,
                new Guaranty(2,"6 months MICROTELL"),
                5000L);


        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);

        //FilterProducts filterProducts = new FilterByCategory();

        Session session = Hibernate.getSessionFactory().openSession();
        logger.info("success session");

    }
}
