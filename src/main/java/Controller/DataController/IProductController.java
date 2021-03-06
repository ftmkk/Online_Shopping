package Controller.DataController;

import Model.ProductModel.Product;

import java.util.List;

public interface IProductController {

    boolean addProduct(Product product);
    Product getProductById(Integer id);
    Product getProductByName(String name);
    List<Product> getProducts();
}
