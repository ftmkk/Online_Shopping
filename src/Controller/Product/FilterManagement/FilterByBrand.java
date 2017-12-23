package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Brand;
import Model.Product.ProductManagement.Product;

import java.util.ArrayList;
import java.util.List;

public class FilterByBrand extends OptionalFilter{

    private FilterProducts filterProducts;
    private List<Brand> brands;

    public FilterByBrand(FilterProducts filterProducts, List<Brand> brands) {
        this.filterProducts = filterProducts;
        this.brands = brands;
    }

    @Override
    public List<Product> filter() {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = filterProducts.filter();

        for(Product product : products){
            if(brands.contains(product.getBrand())){
                result.add(product);
            }
        }
        return result;
    }
}
