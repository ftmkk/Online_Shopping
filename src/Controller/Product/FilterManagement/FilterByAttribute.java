package Controller.Product.FilterManagement;

import Model.Product.AttributeManagement.Attribute;
import Model.Product.ProductManagement.Product;

import java.util.List;

public class FilterByAttribute extends OptionalFilter{

    private FilterProducts filterProducts;
    private List<Attribute> attributes;

    public FilterByAttribute(FilterProducts filterProducts, List<Attribute> attributes) {
        this.filterProducts = filterProducts;
        this.attributes = attributes;
    }

    @Override
    public List<Product> filter() {
        //List<Product> result
        return null;
    }
}
