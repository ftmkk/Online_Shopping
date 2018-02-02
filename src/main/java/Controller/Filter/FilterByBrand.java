package Controller.Filter;

import Model.Entities.ProductInfo.Brand;
import Model.Entities.ProductInfo.Product;

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
        List<Product> result = new ArrayList<>();
        List<Product> products = filterProducts.filter();

        for(Product product : products){
            boolean add = false;
            for(Brand brand : brands){
                if(brand.equals(product.getBrand())){
                    add = true;
                }
            }
            if(add){
                result.add(product);
            }
        }
        return result;
    }
}
