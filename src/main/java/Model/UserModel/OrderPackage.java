package Model.UserModel;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderPackage{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date time;

    @Column
    private Long amount;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderedProduct> productList;

    @Column
    @Enumerated
    private OrderStatus status;

    @Column
    private Long transmissionCost;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Address destination;


    public OrderPackage() {
    }

    public OrderPackage(Date time, Long amount, List<OrderedProduct> productList, OrderStatus status, Long transmissionCost, Address destination) {
        this.time = time;
        this.amount = amount;
        this.productList = productList;
        this.status = status;
        this.transmissionCost = transmissionCost;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Long getAmount() {
        return amount;
    }

    public List<OrderedProduct> getProductList() {
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

    @Override
    public String toString() {
        return "OrderPackage{" +
                "id=" + id +
                ", time=" + time +
                ", amount=" + amount +
                ", productList=" + productList +
                ", status=" + status +
                ", transmissionCost=" + transmissionCost +
                ", destination=" + destination +
                '}';
    }
}
