package Controller.DataController;

import Model.Entities.ProductInfo.Product;

import java.util.List;

public interface IProductController {

    boolean addProduct(Product product);

    boolean removeProduct(Product product);

    Product getProductById(Integer id);
    Product getProductByName(String name);
    List<Product> getProducts();
}
