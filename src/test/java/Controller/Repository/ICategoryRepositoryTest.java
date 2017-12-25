package Controller.Repository;

import Controller.Filter.FilterByCategory;
import Controller.Filter.FilterProducts;
import Model.ProductModel.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class ICategoryRepositoryTest extends TestCase {

    public void test_addCategory_getCategoryByName() {

        ICategoryRepository cr = new CategoryRepository();

        Category categoryA = new Category("a","a");
        cr.addCategory(categoryA);

        Category catA = cr.getCategoryByName("a");

        assertNotNull(catA);
    }

    public void test_addProductToCategory() {
        ICategoryRepository cr = new CategoryRepository();

        Category categoryA = new Category("a","a");
        cr.addCategory(categoryA);
        List<Attribute> attrL1 = new ArrayList<>();
        List<Color> colors1 = new ArrayList<>();
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

        for(Content product : categoryA.getContents()){
            assertEquals(product,p1);
        }
    }

    public void test_addCategoryToCategory() {

        ICategoryRepository cr = new CategoryRepository();

        Category categoryA = new Category("a","a");
        Category categoryB = new Category("b","b");
        cr.addCategory(categoryA);
        cr.addCategory(categoryB);
        cr.addCategoryToCategory(categoryB,categoryA);

        for(Content category : categoryA.getContents()){
            assertEquals(category,categoryB);
        }

    }
}