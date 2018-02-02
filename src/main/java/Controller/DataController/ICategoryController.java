package Controller.DataController;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;

public interface ICategoryController {

    boolean addCategory(Category category);
    Category getCategoryByName(String name);
    void addProductToCategory(Product product, Category category);
    void addCategoryToCategory(Category subCategory, Category superCategory);

}
