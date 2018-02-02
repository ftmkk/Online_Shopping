package Controller.Filter;

import Model.Entities.ProductInfo.Product;

import java.util.ArrayList;
import java.util.List;

public class FilterByPrice extends OptionalFilter{

    private FilterProducts filterProducts;
    private Long minPrice;
    private Long maxPrice;

    public FilterByPrice(FilterProducts filterProducts, Long minPrice, Long maxPrice) {
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
