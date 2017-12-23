package Model.User.OrderManagement;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private String id;
    @Column
    private Date time;
    @Column
    private Long totalPrice;
    @Column
    @OneToMany
    private List<SelectedProduct> productList;
    @Column
    @Enumerated
    private OrderStatus status;
    @Column
    private Long transmissionCost;
    @Column
    @OneToOne
    private Address destination;


    public Order(String id, Date time, Long totalPrice, List<SelectedProduct> productList, OrderStatus status, Long transmissionCost, Address destination) {
        this.id = id;
        this.time = time;
        this.totalPrice = totalPrice;
        this.productList = productList;
        this.status = status;
        this.transmissionCost = transmissionCost;
        this.destination = destination;
    }


    public String getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public List<SelectedProduct> getProductList() {
        return productList;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Long getTransmissionCost() {
        return transmissionCost;
    }

    public Address getDestination() {
        return destination;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProductList(List<SelectedProduct> productList) {
        this.productList = productList;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTransmissionCost(Long transmissionCost) {
        this.transmissionCost = transmissionCost;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }
}
