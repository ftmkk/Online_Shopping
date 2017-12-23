package Model.User.OrderManagement;

import Model.User.AddressManagement.Address;

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

}
