package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Product;

import java.util.ArrayList;
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
        List<Product> result = new ArrayList<>();
        List<Product> products = filterProducts.filter();
        for(Product product : products){
            boolean add = false;
            if(product.getPrice() <= maxPrice && product.getPrice() >= minPrice){
                add = true;
            }
            if(add){
                result.add(product);
            }
        }
        return result;
    }
}
