package Model.ProductModel.ProductInfo;

import Model.DatabaseOperations.Hibernate;

import javax.persistence.*;

@Entity
public class Guaranty {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    public Guaranty(String name) {
        this.name = name;
    }

    public Guaranty() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GuarantyRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
