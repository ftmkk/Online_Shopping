package Controller.Repository;

import Model.ProductModel.Category;
import Model.ProductModel.Product;

public class CategoryRepository implements ICategoryRepository{


    @Override
    public boolean addCategory(Category category) {
        return category.addIfNotExistName();
    }

    @Override
    public Category getCategoryByName(String name) {
        return Category.getByName(name);
    }

    @Override
    public void addProductToCategory(Product product, Category category) {
        category.addContentIfNotExist(product);
    }

    @Override
    public void addCategoryToCategory(Category subCategory, Category superCategory) {
        superCategory.addContentIfNotExist(subCategory);

    }


}
