package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Category;
import Model.Product.ProductManagement.Product;

import java.util.ArrayList;
import java.util.List;

public class FilterByCategory extends FilterProducts{

    private Category category;

    public FilterByCategory(Category category) {
        this.category = category;
    }

    @Override
    public List<Product> filter() {
        List<Product> result = new ArrayList<>();
        //TODO: CONNECT TO DB
        return result;
    }
}
