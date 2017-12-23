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
//        List<Product> result = new ArrayList<Product>();
//        List<Product> products = filterProducts.filter();
//
//        for(Product product : products){
//            if(category product.getBrand())){
//                result.add(product);
//            }
//        }
//        return result;
        return null;
    }
}
