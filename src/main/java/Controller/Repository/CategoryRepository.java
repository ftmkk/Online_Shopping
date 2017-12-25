package Controller.Repository;

import Model.Hibernate;
import Model.ProductModel.Category;
import Model.ProductModel.Content;
import Model.ProductModel.Product;

public class CategoryRepository implements ICategoryRepository{


    @Override
    public boolean addCategory(Category category) {
        return Hibernate.addIfNotExist(category,"name",category.getName());
    }

    @Override
    public Category getCategoryByName(String name) {
        return (Category) Hibernate.getByKey(Category.class,"name",name);
    }


    @Override
    public void addProductToCategory(Product product, Category category) {
        category.getContents().add(product);
        Hibernate.update(category);
    }

    @Override
    public void addCategoryToCategory(Category subCategory, Category superCategory) {
        superCategory.getContents().add(subCategory);
        Hibernate.update(superCategory);
    }


}
