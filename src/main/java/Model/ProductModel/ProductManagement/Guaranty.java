package Model.ProductModel.ProductManagement;

import javax.persistence.*;

@Entity
public class Guaranty {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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
