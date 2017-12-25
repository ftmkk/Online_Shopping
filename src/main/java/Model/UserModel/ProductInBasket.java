package Model.UserModel;

import Model.ProductModel.Color;
import Model.ProductModel.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class ProductInBasket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Product product;

    @Column
    private Integer count;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Color color;

    public ProductInBasket(Product product, Integer count, Color color) {
        this.product = product;
        this.count = count;
        this.color = color;
    }

    public ProductInBasket() {
    }

    @Override
    public String toString() {
        return "ProductInBasket{" +
                "id=" + id +
                ", product=" + product +
                ", count=" + count +
                ", color=" + color +
                '}';
    }
}
