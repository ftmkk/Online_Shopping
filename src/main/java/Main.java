import Model.Hibernate;
import Model.ProductModel.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {

        List<Attribute> attrL = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1",null);
        attrL.add(new Attribute("wight","2.3 kg",attrG,null));
        attrL.add(new Attribute("screen size","1.2 inch",attrG,null));

        List<Color> colors = new ArrayList<>();
        colors.add(new Color("White","White", 0,0,0));



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
                attrL,
                colors,
                new Guaranty("12 months MICROTELL"),
                3000L);

        p1.save();


        logger.info("success session");

    }
}
