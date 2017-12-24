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
    @ManyToOne
    @JoinColumn
    private Product product;
    @Column
    private Integer count;
    @ManyToOne
    @JoinColumn
    private Color color;

    public ProductInBasket(Product product, Integer count, Color color) {
        this.product = product;
        this.count = count;
        this.color = color;
    }
}
