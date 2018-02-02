package Controller.DataController;

import Model.ProductModel.Categorization.Category;
import Model.ProductModel.Categorization.Content;
import Model.ProductModel.Feedback.FeedbackManagement;
import Model.ProductModel.ProductInfo.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ICategoryControllerTest extends TestCase {


    public void test_addCategory_getCategoryByName() {

        ICategoryController cr = new CategoryController();

        Category categoryA = new Category("a","a");
        cr.addCategory(categoryA);

        Category catA = cr.getCategoryByName("a");

        assertNotNull(catA);
    }

    public void test_addProductToCategory() {
        ICategoryController cr = new CategoryController();

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
                3000L,
                new FeedbackManagement());

        for(Content product : categoryA.getContents()){
            assertEquals(product,p1);
        }
    }

    public void test_addCategoryToCategory() {

        ICategoryController cr = new CategoryController();

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