package Model.ProductModel.ProductInfo;


import Model.DatabaseOperations.Hibernate;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String persianName;

    public Brand(String name, String persianName) {
        this.name = name;
        this.persianName = persianName;
    }

    public Brand() {
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

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public boolean equals(Brand brand){
        return this.getName().equals(brand.getName());
    }


    public void flush(){

    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persianName='" + persianName + '\'' +
                '}';
    }
}