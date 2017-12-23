package Model.Product.ProductManagement;

import org.w3c.dom.css.RGBColor;

public class Color {

    private Integer id;
    private String name;
    private RGBColor rgb;

    public Color(Integer id, String name, RGBColor rgb) {
        this.id = id;
        this.name = name;
        this.rgb = rgb;
    }


    public boolean equals(Color color){
        return color.id.equals(this.id);
    }
}
