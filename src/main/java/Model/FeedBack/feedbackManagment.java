package Model.FeedBack;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class feedbackManagment{

    @Column
    @OneToMany(cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Comment> comments;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Question> questions;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Answer> answers;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public Score score;

    public feedbackManagment(List<Comment> comments, List<Answer> answers, Score score, List<Question> questions) {
        this.comments = comments;
        this.answers = answers;
        this.score = score;
        this.questions = questions;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "feedbackManagment{" +
                "comments=" + comments +
                ", questions=" + questions +
                ", answers=" + answers +
                ", score=" + score +
                '}';
    }
}
