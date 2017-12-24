package Controller.ProductController.Filter;

import Model.ProductModel.Color;
import Model.ProductModel.Product;

import java.util.ArrayList;
import java.util.List;

public class FilterByColor extends OptionalFilter{

    private FilterProducts filterProducts;
    private List<Color> colors;

    public FilterByColor(FilterProducts filterProducts, List<Color> colors) {
        this.filterProducts = filterProducts;
        this.colors = colors;
    }

    @Override
    public List<Product> filter() {
        List<Product> result = new ArrayList<>();
        List<Product> products = filterProducts.filter();
        for(Product product : products){
            boolean add = false;
            List<Color> productColors = product.getColors();
            for(Color productColor : productColors) {
                for(Color color : colors){
                    if(color.equals(productColor)){
                        add = true;
                    }
                }
            }
            if(add){
                result.add(product);
            }
        }
        return result;
    }
}
