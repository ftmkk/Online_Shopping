package Controller.Filter;

import Model.ProductModel.ProductInfo.Product;

import java.util.List;

public abstract class OptionalFilter implements FilterProducts {

    public abstract List<Product> filter();

}
