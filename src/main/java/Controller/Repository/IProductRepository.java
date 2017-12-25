package Controller.Repository;

import Model.ProductModel.Product;

import java.util.List;

public interface IProductRepository {

    boolean addProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getProducts();
}
