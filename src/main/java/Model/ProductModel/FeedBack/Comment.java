package Model.ProductModel.FeedBack;

import Model.DatabaseOperations.Hibernate;
import Model.UserModel.UserInfo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class Comment extends Feedback {

    @Column
    private String comment_title;

    @Column
    private String comment_content;

    @Column
    private Date comment_date;

    public Comment(Date date, User creator, String comment_title, Date comment_date, String comment_content) {
        super(date, creator);
        this.comment_title = comment_title;
        this.comment_date = comment_date;
        this.comment_content = comment_content;
    }

    public String getComment_title() {
        return comment_title;
    }

    public void setComment_title(String comment_title) {
        this.comment_title = comment_title;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public boolean AddComment(){
        return true;
    }

    public boolean deleteComment(){
        return true;
    }


    public boolean add(){
        try {
            Hibernate.add(this);
            return true;
        }catch (Exception e){
            System.out.print(e.toString());
            return false;
        }
    }

    public boolean remove(){
        try {
            Hibernate.delete(this);
            return true;
        }catch (Exception e){
            System.out.print(e.toString());
            return false;
        }
    }

    public boolean modify(){
        try {
            Hibernate.update(this);
            return true;
        }catch (Exception e){
            System.out.print(e.toString());
            return false;
        }
    }
}
