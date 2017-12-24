package Model.ProductModel;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String persianName;

    public Brand(String name, String persianName) {
        this.name = name;
        this.persianName = persianName;
    }

    public Brand() {
    }

    public boolean equals(Brand brand){
        return this.id.equals(brand.id);
    }
}