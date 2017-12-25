package Controller.ProductController.Repository;

import Model.ProductModel.Product;

public interface IProductRepository {

    boolean addProduct(Product product);
    Product getProductById(Integer id);
}
