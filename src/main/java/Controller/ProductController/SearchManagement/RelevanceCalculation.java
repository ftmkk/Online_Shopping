package Controller.ProductController.SearchManagement;

import Model.ProductModel.ProductManagement.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface RelevanceCalculation {

    HashMap<Product , Double> calculate(String query, List<Product> product) throws IOException;


}
