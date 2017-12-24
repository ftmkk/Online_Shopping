package Model.Product.ProductManagement;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
public abstract class AbstractContent {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;

    abstract void setContents();
    abstract List<Product> getProducts();

}
