package Controller.Product.SearchManagement;
import Controller.Product.SearchManagement.TfIdf.RelevenceCalculationTFIDF;
import Model.Product.ProductManagement.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SearchProducts {

    private String query;
    private List<Product> products;
    private HashMap<Product,Float> productScores;
    private String kind;

    public SearchProducts(String query, List<Product> products) {
        this.query = query;
        this.products = products;
    }

    private String[] parseDocument(){

        return null;
    }

    private void setProductScores() throws IOException {

        RelevanceCalculation relevanceCalculation = new RelevenceCalculationTFIDF();
        HashMap<Product , Double> scores = relevanceCalculation.calculate(query,products);
    }

    public List<Product> getRelevantProduct(float threshold){
        //TODO
        return null;
    }


}
