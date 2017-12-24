package Model.ProductModel;

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

    abstract void setContents();
    abstract List<Product> getProducts();

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
}
