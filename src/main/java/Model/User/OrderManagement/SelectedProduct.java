package Model.User.OrderManagement;

import Model.Product.ProductManagement.Color;
import Model.Product.ProductManagement.Guaranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SelectedProduct {

    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private Integer count;
    @Column
    private Long unitPrice;
    @Column
    private Color color;
    @Column
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
}
