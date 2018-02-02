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
public class Answer extends Feedback {

    @Column
    private String answer_content;

    public Answer(Date date, User creator, String answer_content) {
        super(date, creator);
        this.answer_content = answer_content;
    }

    public Answer() {
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
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
