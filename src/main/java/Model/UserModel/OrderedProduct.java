package Model.UserModel;

import Model.ProductModel.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn
public class OrderedProduct extends Product {

    @Column
    private Integer count;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    private Color color;

    @Column
    private Long totalPrice;


    public OrderedProduct(String name, String persianName, Long price, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, String review, Brand brand, List<Attribute> attributes, List<Color> colors, Guaranty guaranty, Long discount, Integer count, Color color, Long totalPrice) {
        super(name, persianName, price, status, remainingCount, briefDescription, visitCount, sellCount, releaseDate, review, brand, attributes, colors, guaranty, discount);
        this.count = count;
        this.color = color;
        this.totalPrice = totalPrice;
    }

    public OrderedProduct() {
    }
}
