package Model.ProductModel;

import javax.persistence.*;

@Entity
public class Guaranty {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @Transient
    private String name;

    public Guaranty(String name) {
        this.name = name;
    }

    public Guaranty() {
    }

}
