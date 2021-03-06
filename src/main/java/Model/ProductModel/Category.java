package Model.ProductModel;

import Model.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
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

    public boolean addContentIfNotExist(Content content){
        if(!hasContent(content)){
            this.getContents().add(content);
            Hibernate.update(this);
            return true;
        }
        Hibernate.update(this);
        return false;
    }

    public static Category getByName(String name) {
        return (Category) Hibernate.getByKey(Category.class,"name",name);
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


    public boolean addIfNotExistName(){
        String key = "name";
        String value = this.getName();
        boolean result = Hibernate.addIfNotExist(this,key,value);
        Category g = (Category) Hibernate.getByKey(this.getClass(),key,value);
        this.setId(g.getId());
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "contents=" + contents +
                '}';
    }
}
