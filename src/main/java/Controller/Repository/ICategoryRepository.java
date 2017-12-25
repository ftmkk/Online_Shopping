package Controller.Repository;

import Model.ProductModel.Category;
import Model.ProductModel.Product;

public interface ICategoryRepository {

    boolean addCategory(Category category);
    Category getCategoryByName(String name);
    void addProductToCategory(Product product, Category category);
    void addCategoryToCategory(Category subCategory, Category superCategory);

}
