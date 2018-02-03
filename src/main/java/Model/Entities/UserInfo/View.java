package Model.Entities.UserInfo;

import Model.Entities.ProductInfo.Product;
import Model.Entities.UserInfo.User;
import org.apache.lucene.util.automaton.DaciukMihovAutomatonBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nejati on 03/02/2018.
 */

@Entity
public class View{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Product product;

    @Column
    private Date date;

    @Column
    private User user;

    public View(Product product, User user, Date date) {
        this.product = product;
        this.user = user;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", product=" + product +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
