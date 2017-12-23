package Controller.Product.SearchManagement;

import Model.Product.ProductManagement.Product;

import java.util.HashMap;
import java.util.List;

public class SearchProducts {

    private String query;
    private List<Product> products;
    private HashMap<Product,Float> productScores;

    public SearchProducts(String query, List<Product> products) {
        this.query = query;
        this.products = products;
    }

    private void setProductScores(){
        //TODO
    }

    public List<Product> getRelevantProduct(float threshold){
        //TODO
        return null;
    }
}
