package Controller.DataController;

import Model.ProductModel.Categorization.Category;
import Model.ProductModel.ProductInfo.Product;

public interface ICategoryController {

    boolean addCategory(Category category);
    Category getCategoryByName(String name);
    void addProductToCategory(Product product, Category category);
    void addCategoryToCategory(Category subCategory, Category superCategory);

}
