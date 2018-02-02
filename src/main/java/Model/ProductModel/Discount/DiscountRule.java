package Model.ProductModel.Discount;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class DiscountRule {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String discount_type;

    @Column
    private int discount_value;

    @Column
    private Date discount_startDate;

    @Column
    private Date discount_endDate;

    @Column
    private boolean active;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products;

    public DiscountRule() {
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public int getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(int discount_value) {
        this.discount_value = discount_value;
    }

    public Date getDiscount_startDate() {
        return discount_startDate;
    }

    public void setDiscount_startDate(Date discount_startDate) {
        this.discount_startDate = discount_startDate;
    }

    public Date getDiscount_endDate() {
        return discount_endDate;
    }

    public void setDiscount_endDate(Date discount_endDate) {
        this.discount_endDate = discount_endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DiscountRule(String discount_type, int discount_value, Date discount_startDate, Date discount_endDate, boolean active, List<Product> products) {
        this.discount_type = discount_type;
        this.discount_value = discount_value;
        this.discount_startDate = discount_startDate;
        this.discount_endDate = discount_endDate;
        this.active = active;
        this.products = products;
    }

    public void updateDiscount(int newValue){

        this.discount_value = newValue;
    }


    public void invalidDiscount(){
        this.active = false;
    }

    public void addDiscount(){
        try {
            Hibernate.add(this);
        }catch (Exception e){
            System.out.print(e.toString());
        }

        for(Product p : products){
            p.setPrice(p.getPrice()*(100-this.discount_value)*100);
        }
    }

    public void removeDiscount(){
        try {
            Hibernate.delete(this);
        }catch (Exception e){
            System.out.print(e.toString());
        }
    }


    @Override
    public String toString() {
        return "DiscountRule{" +
                "discount_type='" + discount_type + '\'' +
                ", discount_value='" + discount_value + '\'' +
                ", discount_startDate=" + discount_startDate +
                ", discount_endDate=" + discount_endDate +
                ", active=" + active +
                ", products=" + products +
                '}';
    }
}