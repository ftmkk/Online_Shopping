package Controller.Product.SearchManagement.TfIdf;

import Controller.Product.SearchManagement.RelevanceCalculation;
import Model.Product.ProductManagement.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by macintosh on 12/23/17.
 */
public interface ICalculationTFIDF extends RelevanceCalculation{

    HashMap<Product , Double> calculate(String query, List<Product> product) throws IOException;

}
