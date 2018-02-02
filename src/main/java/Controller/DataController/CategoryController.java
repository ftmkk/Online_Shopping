package Controller.DataController;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;
import Model.Repository.CategoryRepository;

public class CategoryController implements ICategoryController {


    @Override
    public boolean addCategory(Category category) {
        return CategoryRepository.addIfNotExistName(category);
    }

    @Override
    public boolean removeCategory(Category category) {
        return CategoryRepository.removeIfExistName(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        return CategoryRepository.getByName(name);
    }

    @Override
    public void addProductToCategory(Product product, Category category) {
        CategoryRepository.addContentIfNotExist(category, product);
    }

    @Override
    public boolean removeProductFromCategory(Product product, Category category) {
        return CategoryRepository.removeContentIfExist(category, product);
    }

    @Override
    public void addCategoryToCategory(Category subCategory, Category superCategory) {
        CategoryRepository.addContentIfNotExist(superCategory, subCategory);

    }

    @Override
    public void removeCategoryFromCategory(Category subCategory, Category superCategory) {
        CategoryRepository.removeContentIfExist(superCategory, subCategory);

    }
    
}
