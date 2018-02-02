package Model.ProductModel.Categorization;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends Content {

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Content> contents;

    public Category(String name, String persianName) {
        super(name, persianName);
        this.contents = new ArrayList<>();
    }

    public Category() {
    }

    public boolean hasContent(Content content){
        for(Content contentInCategory : this.getContents()){
            if(contentInCategory.getName().equals(content.getName())){
                return true;
            }
        }
        return false;
    }


    public List<Content> getContents() {
        return contents;
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


    @Override
    public String toString() {
        return "Category{" +
                "contents=" + contents +
                '}';
    }
}
