package Model.ProductModel;


import javax.persistence.*;

@Entity

public class Brand {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @Transient
    private String name;

    @Column(unique = true)
    @Transient
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