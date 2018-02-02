package Controller.DataController;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;

public interface ICategoryController {

    boolean addCategory(Category category);

    boolean removeCategory(Category category);

    Category getCategoryByName(String name);
    void addProductToCategory(Product product, Category category);

    boolean removeProductFromCategory(Product product, Category category);

    void addCategoryToCategory(Category subCategory, Category superCategory);

    void removeCategoryFromCategory(Category subCategory, Category superCategory);
}
