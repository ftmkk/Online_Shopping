package Model.UserModel;

import Model.ProductModel.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @LazyCollection(LazyCollectionOption.FALSE)
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

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "count=" + count +
                ", color=" + color +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
