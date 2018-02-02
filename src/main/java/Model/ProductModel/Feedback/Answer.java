package Model.ProductModel.Feedback;

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
    private String content;

    public Answer(Date date, User creator, String content) {
        super(date, creator);
        this.content = content;
    }

    public Answer() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String answer_content) {
        this.content = answer_content;
    }


}
