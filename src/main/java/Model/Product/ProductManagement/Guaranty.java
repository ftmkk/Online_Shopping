package Model.Product.ProductManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guaranty {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private String name;

    public Guaranty(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Guaranty() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
