package Model.Entities.Categorization;

import Model.Entities.ProductInfo.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Content {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String persianName;

    protected Content() {
    }

    protected abstract List<Product> getProducts();

    public String getName() {
        return name;
    }

    public String getPersianName() {
        return persianName;
    }

    public Content(String name, String persianName) {
        this.name = name;
        this.persianName = persianName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }


    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persianName='" + persianName + '\'' +
                '}';
    }

}