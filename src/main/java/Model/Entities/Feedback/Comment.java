package Model.Entities.Feedback;

import Model.Entities.UserInfo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class Comment extends Feedback {

    @Column
    private String title;

    @Column
    private String content;


    public Comment(Date date, User creator, String title, String content) {
        super(date, creator);
        this.title = title;
        this.content = content;
    }

    public Comment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String comment_title) {
        this.title = comment_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String comment_content) {
        this.content = comment_content;
    }


}
