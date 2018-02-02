package Model.Entities.Feedback;

import Model.Entities.UserInfo.User;
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
    private String content;

    @Column
    private String title;

    public Question(Date date, User creator, List<Answer> answers, String _title, String content) {
        super(date, creator);
        this.answers = answers;
        title = _title;
        this.content = content;
    }

    public Question() {
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answers=" + answers +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
