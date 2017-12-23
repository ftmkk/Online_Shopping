package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Color;
import Model.Product.ProductManagement.Product;

import java.util.List;

public class FilterByColor extends OptionalFilter{

    private FilterProducts filterProducts;
    private List<Color> color;

    public FilterByColor(FilterProducts filterProducts, List<Color> color) {
        this.filterProducts = filterProducts;
        this.color = color;
    }

    @Override
    public List<Product> filter() {
        //TODO
        return null;
    }
}
