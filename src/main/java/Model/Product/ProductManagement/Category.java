package Model.Product.ProductManagement;

import Model.Product.AttributeManagement.AttributeRepository;

import java.util.ArrayList;
import java.util.List;

public class Category implements AbstractContent {

    private String name;
    private String persianName;
    private List<AbstractContent> contents;
    private List<Brand> brands;
    private AttributeRepository possibleAttrs;


    public void setContents() {
        //QUERY
        for(AbstractContent content : contents){
           content.setContents();
        }
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        for(AbstractContent content : contents){
            List<Product> subProducts = content.getProducts();
            for(Product product : subProducts){
                products.add(product);
            }
        }
        return products;
    }
}
