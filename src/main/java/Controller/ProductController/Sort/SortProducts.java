package Controller.ProductController.Sort;

import Model.ProductModel.Product;

import java.util.List;

public interface SortProducts {

    List<Product> sort(List<Product> products , boolean isAsc);
}