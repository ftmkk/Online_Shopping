package Model.ProductModel.ProductManagement;


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

    public Brand(Integer id, String name, String persianName) {
        this.id = id;
        this.name = name;
        this.persianName = persianName;
    }

    public Brand() {
    }

    public boolean equals(Brand brand){
        return this.id.equals(brand.id);
    }
}