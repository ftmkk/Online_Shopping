package Model.Entities.Discount;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.ProductInfo.Product;
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

    @Column(unique = true)
    private String name;

    @Column
    private String type;

    @Column
    private int value;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private boolean active;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products;

    public DiscountRule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String discount_type) {
        this.type = discount_type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int discount_value) {
        this.value = discount_value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date discount_startDate) {
        this.startDate = discount_startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date discount_endDate) {
        this.endDate = discount_endDate;
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

    public DiscountRule(String type, int value, Date startDate, Date endDate, boolean active, List<Product> products) {
        this.type = type;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.products = products;
    }

    public boolean hasProductInProductList(Product product){
        for(Product productInList : this.getProducts()){
            if(productInList.getName().equals(product.getName())){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "DiscountRule{" +
                "discount_type='" + type + '\'' +
                ", discount_value='" + value + '\'' +
                ", discount_startDate=" + startDate +
                ", discount_endDate=" + endDate +
                ", active=" + active +
                ", products=" + products +
                '}';
    }
}