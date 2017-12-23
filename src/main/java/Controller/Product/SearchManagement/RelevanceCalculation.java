package Controller.Product.SearchManagement;

import Model.Product.ProductManagement.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface RelevanceCalculation {

    HashMap<Product , Double> calculate(String query, List<Product> product) throws IOException;


}
