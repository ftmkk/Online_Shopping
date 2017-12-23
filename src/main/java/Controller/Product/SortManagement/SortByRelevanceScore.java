package Controller.Product.SortManagement;

import Model.Product.ProductManagement.Product;

import java.util.Comparator;
import java.util.List;

public class SortByRelevanceScore implements SortProducts{

    @Override
    public List<Product> sort(List<Product> products , boolean isAsc) {

        //products.sort(Comparator.comparing(Product::getSellCount));

        //products.forEach(System.out::println);

        return null;
    }
}
