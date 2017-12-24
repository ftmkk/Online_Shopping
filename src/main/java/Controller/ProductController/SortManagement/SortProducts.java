package Controller.ProductController.SortManagement;

import Model.ProductModel.ProductManagement.Product;

import java.util.List;

public interface SortProducts {

    List<Product> sort(List<Product> products , boolean isAsc);
}
