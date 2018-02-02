package Controller.Filter;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;

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
