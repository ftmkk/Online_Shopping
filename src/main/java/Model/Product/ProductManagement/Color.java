package Model.Product.ProductManagement;

import org.w3c.dom.css.RGBColor;

public class Color {

    private Integer id;
    private String name;
    private Integer r;
    private Integer g;
    private Integer b;

    public Color(Integer id, String name, Integer r, Integer g, Integer b) {
        this.id = id;
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
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
