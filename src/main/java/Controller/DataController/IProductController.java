package Controller.DataController;

import Model.ProductModel.ProductInfo.Product;

import java.util.List;

public interface IProductController {

    boolean addProduct(Product product);
    Product getProductById(Integer id);
    Product getProductByName(String name);
    List<Product> getProducts();
}
