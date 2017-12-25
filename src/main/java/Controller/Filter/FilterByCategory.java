package Controller.Filter;

import Model.Hibernate;
import Model.ProductModel.Category;
import Model.ProductModel.Content;
import Model.ProductModel.Product;

import java.util.List;

public class FilterByCategory implements FilterProducts{

    private Category category;

    public FilterByCategory(Category category) {
        this.category = category;
    }

    @Override
    public List<Product> filter() {
        return category.getProducts();
    }
}
