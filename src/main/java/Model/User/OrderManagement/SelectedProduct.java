package Model.User.OrderManagement;

import Model.Product.ProductManagement.Color;
import Model.Product.ProductManagement.Guaranty;

public class SelectedProduct {

    private Integer count;
    private Long unitPrice;
    private Color color;
    private Guaranty guaranty;
    private Long discount;
    private Long totalPrice;

    public SelectedProduct(Integer count, Long unitPrice, Color color, Guaranty guaranty, Long discount, Long totalPrice) {
        this.count = count;
        this.unitPrice = unitPrice;
        this.color = color;
        this.guaranty = guaranty;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }
}
