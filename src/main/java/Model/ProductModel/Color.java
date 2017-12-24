package Model.ProductModel;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
