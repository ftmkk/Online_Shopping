package Model.Product.ProductManagement;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brand {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
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