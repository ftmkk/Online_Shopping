package Model.Entities.Feedback;

import Model.Entities.UserInfo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
public class Score extends Feedback {

    @Column
    private Boolean score;

    public Score(Date date, User creator, Boolean score) {
        super(date, creator);
        this.score = score;
    }

    public Score() {
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }

}
