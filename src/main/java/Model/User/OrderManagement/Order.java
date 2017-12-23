package Model.User.OrderManagement;

import java.util.Date;
import java.util.List;

public class Order {

    private String code;
    private Date time;
    private Long totalPrice;
    private List<SelectedProduct> productList;
    private OrderStatus status;
    private Long transmissionCost;
    private Address destination;


    public Order(String code, Date time, Long totalPrice, List<SelectedProduct> productList, OrderStatus status, Long transmissionCost, Address destination) {
        this.code = code;
        this.time = time;
        this.totalPrice = totalPrice;
        this.productList = productList;
        this.status = status;
        this.transmissionCost = transmissionCost;
        this.destination = destination;
    }


    public String getCode() {
        return code;
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

    public void setCode(String code) {
        this.code = code;
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
