package Model.User.OrderManagement;

import Model.Product.ProductManagement.Color;
import Model.Product.ProductManagement.Guaranty;

import javax.persistence.*;

@Entity
public class SelectedProduct {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer count;
    @Column
    private Long unitPrice;
    @ManyToOne
    @JoinColumn
    private Color color;
    @ManyToOne
    @JoinColumn
    private Guaranty guaranty;
    @Column
    private Long discount;
    @Column
    private Long totalPrice;

    public SelectedProduct(Integer id, Integer count, Long unitPrice, Color color, Guaranty guaranty, Long discount, Long totalPrice) {
        this.id = id;
        this.count = count;
        this.unitPrice = unitPrice;
        this.color = color;
        this.guaranty = guaranty;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public SelectedProduct() {
    }
}
