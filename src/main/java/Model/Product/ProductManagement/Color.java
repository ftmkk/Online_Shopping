package Model.Product.ProductManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Color {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer r;
    @Column
    private Integer g;
    @Column
    private Integer b;

    public Color(Integer id, String name, Integer r, Integer g, Integer b) {
        this.id = id;
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color() {
    }

    public boolean equals(Color color){
        return color.id.equals(this.id);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getR() {
        return r;
    }

    public Integer getG() {
        return g;
    }

    public Integer getB() {
        return b;
    }
}
