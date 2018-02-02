package Model.FeedBack;

import Model.UserModel.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
@Inheritance
public class feedback {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public User creator;

    @Column
    private Date date;

    public feedback(Date date, User creator) {
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
        return "feedback{" +
                "id=" + id +
                ", creator=" + creator +
                ", date=" + date +
                '}';
    }
}
