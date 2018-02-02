package Controller.Filter;

import Controller.DataController.*;
import Model.ProductModel.Categorization.Category;
import Model.ProductModel.Feedback.FeedbackManagement;
import Model.ProductModel.ProductInfo.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class FilterProductsTest extends TestCase {

    public void testFilter() {

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
                50000000L,
                ProductStatus.AVAILABLE,
                233,
                "THis is product p1!",
                2234,
                923,
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
                3000L,
                new FeedbackManagement());


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

        FilterProducts A = new FilterByCategory(catC);

        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand("Samsung","SAMSUNG"));
        FilterProducts C_Samsung = new FilterByBrand(A, brandList);

        FilterProducts C_Samsung_Price = new FilterByPrice(C_Samsung,40000000L,60000000L);

        for(Product product : C_Samsung_Price.filter()){
            assertEquals(p1.getId(),product.getId());
        }


    }
}