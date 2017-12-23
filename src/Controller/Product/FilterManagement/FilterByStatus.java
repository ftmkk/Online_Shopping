package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Product;
import Model.Product.ProductManagement.ProductStatus;

import java.util.List;

public class FilterByStatus extends OptionalFilter{

    private FilterProducts filterProducts;
    private ProductStatus status;

    public FilterByStatus(FilterProducts filterProducts, ProductStatus status) {
        this.filterProducts = filterProducts;
        this.status = status;
    }

    @Override
    public List<Product> filter() {
        //TODO
        return null;
    }
}
