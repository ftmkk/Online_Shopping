package Controller.Filter;

import Model.Entities.ProductInfo.Product;
import Model.Entities.ProductInfo.ProductStatus;

import java.util.ArrayList;
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
        List<Product> result = new ArrayList<>();
        List<Product> products = filterProducts.filter();
        for(Product product : products){
            boolean add = false;
            if(product.getStatus().equals(status)){
                add = true;
            }
            if(add){
                result.add(product);
            }
        }
        return result;
    }
}
