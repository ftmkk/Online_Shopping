package Model.Product.ProductManagement;

import Model.Product.AttributeManagement.AttributeRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractContent {

    @Column
    private String name;
    @Column
    private String persianName;
    @Column
    @OneToMany
    private List<AbstractContent> contents;
    @Column
    @OneToMany
    private List<Brand> brands;
    @Column
    @OneToOne
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
