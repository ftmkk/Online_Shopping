package Model.ProductModel;

import Model.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Color implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String persianName;

    @Column
    private Integer r;

    @Column
    private Integer g;

    @Column
    private Integer b;

    public Color(String name, String persianName, Integer r, Integer g, Integer b) {
        this.name = name;
        this.persianName = persianName;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color() {
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public boolean equals(Color color){
        return color.getName().equals(this.getName());

    }

    public boolean addIfNotExistName(){
        String key = "name";
        String value = this.getName();
        return Hibernate.addIfNotExist(this,key,value);
    }
    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persianName='" + persianName + '\'' +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }
}
