package Controller.Product.SearchManagement;

import Model.Product.ProductManagement.Product;

public interface RelevanceCalculation {

    float calculate(String query, Product product);
}
