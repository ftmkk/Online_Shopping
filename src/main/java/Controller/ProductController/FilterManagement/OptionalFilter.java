package Controller.ProductController.FilterManagement;

import Model.ProductModel.ProductManagement.Product;

import java.util.List;

public abstract class OptionalFilter extends FilterProducts {

    public abstract List<Product> filter();

}
