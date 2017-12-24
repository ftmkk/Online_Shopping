package Controller.ProductController.Filter;

import Model.ProductModel.Product;

import java.util.List;

public abstract class OptionalFilter extends FilterProducts {

    public abstract List<Product> filter();

}
