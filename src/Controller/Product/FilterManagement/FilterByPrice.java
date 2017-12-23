package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Product;

import java.util.List;

public class FilterByPrice extends OptionalFilter{

    private FilterProducts filterProducts;
    private Integer minPrice;
    private Integer maxPrice;

    public FilterByPrice(FilterProducts filterProducts, Integer minPrice, Integer maxPrice) {
        this.filterProducts = filterProducts;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter() {
        //TODO
        return null;
    }
}
