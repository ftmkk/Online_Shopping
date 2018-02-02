package Controller.Sort;

import Model.Entities.ProductInfo.Product;

import java.util.List;

public class SortByRelevanceScore implements SortProducts{

    private List<Product> products;
    private boolean isAsc;

    public SortByRelevanceScore(List<Product> products, boolean isAsc) {
        this.products = products;
        this.isAsc = isAsc;
    }

    @Override
    public List<Product> sort() {

        //products.sort(Comparator.comparing(Product::getSellCount));

        //products.forEach(System.out::println);

        return null;
    }
}
