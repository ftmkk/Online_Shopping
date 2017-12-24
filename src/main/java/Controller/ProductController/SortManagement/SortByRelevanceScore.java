package Controller.ProductController.SortManagement;

import Model.ProductModel.ProductManagement.Product;

import java.util.List;

public class SortByRelevanceScore implements SortProducts{

    @Override
    public List<Product> sort(List<Product> products , boolean isAsc) {

        //products.sort(Comparator.comparing(Product::getSellCount));

        //products.forEach(System.out::println);

        return null;
    }
}
