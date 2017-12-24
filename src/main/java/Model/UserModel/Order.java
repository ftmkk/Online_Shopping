package Model.UserModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private Date time;

    @Column
    private Long amount;

    @Column
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<OrderedProduct> productList;

    @Column
    @Enumerated
    private OrderStatus status;

    @Column
    private Long transmissionCost;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Address destination;


    public Order() {
    }

    public Order(Date time, Long amount, List<OrderedProduct> productList, OrderStatus status, Long transmissionCost, Address destination) {
        this.time = time;
        this.amount = amount;
        this.productList = productList;
        this.status = status;
        this.transmissionCost = transmissionCost;
        this.destination = destination;
    }
}
