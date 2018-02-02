package Model.ProductModel.FeedBack;

import Model.UserModel.UserInfo.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
@Inheritance
public class Feedback {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private User creator;

    @Column
    private Date date;

    public Feedback(Date date, User creator) {
        this.date = date;
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }



    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", creator=" + creator +
                ", date=" + date +
                '}';
    }
}
