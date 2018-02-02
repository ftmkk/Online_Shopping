package Model.UserModel.Order;

import Model.ProductModel.ProductInfo.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class OrderedProduct extends ProductInBasket {

    @Column
    private Long price;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Brand brand;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Guaranty guaranty;

    @Column
    private Long discount;

    @Column
    private Long totalPrice;



    public OrderedProduct(Product product, Integer count, Color color, Long price, Brand brand, Guaranty guaranty, Long discount, Long totalPrice) {
        super(product, count, color);
        this.price = price;
        this.brand = brand;
        this.guaranty = guaranty;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public OrderedProduct(ProductInBasket productInBasket){
        this.setProduct(productInBasket.getProduct());
        this.setCount(productInBasket.getCount());
        this.setColor(productInBasket.getColor());
        this.price = productInBasket.getProduct().getPrice();
        this.brand = productInBasket.getProduct().getBrand();
        this.guaranty = productInBasket.getProduct().getGuaranty();
        this.discount = productInBasket.getProduct().getDiscount();
        this.totalPrice = this.getCount()*(this.price*this.discount);
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderedProduct() {
    }

}
