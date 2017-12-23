package Controller.Product.FilterManagement;

import Model.Product.ProductManagement.Product;

import java.util.List;

public abstract class OptionalFilter extends FilterProducts {

    public abstract List<Product> filter();

}
