package Controller.ProductController.Filter;

import Model.ProductModel.Product;
import Controller.ProductController.Search.SearchProducts;

import java.util.List;

public class FilterByQuery extends OptionalFilter{

    private FilterProducts filterProducts;
    private String query;
    private Float threshold;

    public FilterByQuery(FilterProducts filterProducts, String query, Float threshold) {
        this.filterProducts = filterProducts;
        this.query = query;
        this.threshold = threshold;
    }

    @Override
    public List<Product> filter() {
        List<Product> products = filterProducts.filter();
        SearchProducts search = new SearchProducts(query, products);
        List<Product> result = search.getRelevantProduct(threshold);
        return result;
    }
}
