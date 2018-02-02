package Model.ProductModel.FeedBack;

import Model.DatabaseOperations.Hibernate;
import Model.UserModel.UserInfo.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class Question extends Feedback {

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answers;

    @Column
    private String Question_Content;

    @Column
    private String Question_title;

    public Question(Date date, User creator, List<Answer> answers, String question_title, String question_Content) {
        super(date, creator);
        this.answers = answers;
        Question_title = question_title;
        Question_Content = question_Content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestion_title() {
        return Question_title;
    }

    public void setQuestion_title(String question_title) {
        Question_title = question_title;
    }

    public String getQuestion_Content() {
        return Question_Content;
    }

    public void setQuestion_Content(String question_Content) {
        Question_Content = question_Content;
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

    @Override
    public String toString() {
        return "Question{" +
                "answers=" + answers +
                ", Question_Content='" + Question_Content + '\'' +
                ", Question_title='" + Question_title + '\'' +
                '}';
    }
}
