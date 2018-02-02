package Model.ProductModel.FeedBack;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class FeedbackManagement {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @OneToMany(cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questions;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Score> scores;

    public FeedbackManagement(List<Comment> comments, List<Score> scores, List<Question> questions) {
        this.comments = comments;
        this.scores = scores;
        this.questions = questions;
    }


    public FeedbackManagement() {
        this.comments = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.questions = new ArrayList<>();
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Score> getScores() {
        return scores;
    }


    public void setScore(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "FeedbackManagement{" +
                "comments=" + comments +
                ", questions=" + questions +
                ", scores=" + scores +
                '}';
    }
}
