package Model.UserModel;

import Model.ProductModel.Color;
import Model.ProductModel.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Inheritance
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

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getCount() {
        return count;
    }

    public Color getColor() {
        return color;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setColor(Color color) {
        this.color = color;
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
