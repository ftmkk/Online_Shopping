package Model.ProductModel;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
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

    public boolean equals(Color color){
        return color.id.equals(this.id);
    }

}
