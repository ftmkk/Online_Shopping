package Model.UserModel;

import Model.ProductModel.Color;
import Model.ProductModel.Product;

import javax.persistence.*;

@Entity
public class ProductInBasket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Product product;

    @Column
    private Integer count;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Color color;

    public ProductInBasket(Product product, Integer count, Color color) {
        this.product = product;
        this.count = count;
        this.color = color;
    }

    public ProductInBasket() {
    }
}
