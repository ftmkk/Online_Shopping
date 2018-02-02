package Controller.Search.TfIdf;

import Controller.Search.RelevanceCalculation;
import Model.Entities.ProductInfo.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by macintosh on 12/23/17.
 */
public class RelevenceCalculationTFIDF implements RelevanceCalculation {

    public HashMap<Product, Double> calculate(String query, List<Product> product ) throws IOException {

        HashMap<Product , Double> result = new HashMap<>();
        DocumentParser documentParser = new DocumentParser();
        documentParser.parseFiles(product,query);
        result = documentParser.tfIdfCalculator();
        return  result;
    }
}
