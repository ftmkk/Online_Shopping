package Model.ProductModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends Content {

    @Column
    @OneToMany
    private List<Content> contents;

    public Category(String name, String persianName, List<Content> contents) {
        super(name, persianName);
        this.contents = contents;
    }

    public Category() {
    }

    public void setContents() {
        //QUERY
        for(Content content : contents){
           content.setContents();
        }
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        for(Content content : contents){
            List<Product> subProducts = content.getProducts();
            for(Product product : subProducts){
                products.add(product);
            }
        }
        return products;
    }
}
