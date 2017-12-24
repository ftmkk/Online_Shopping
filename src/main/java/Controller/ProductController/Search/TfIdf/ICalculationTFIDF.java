package Controller.ProductController.Search.TfIdf;

import Controller.ProductController.Search.RelevanceCalculation;
import Model.ProductModel.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by macintosh on 12/23/17.
 */
public interface ICalculationTFIDF extends RelevanceCalculation {

    HashMap<Product , Double> calculate(String query, List<Product> product) throws IOException;

}
