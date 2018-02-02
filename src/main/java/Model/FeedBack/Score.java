package Model.FeedBack;

import Model.Hibernate;
import Model.UserModel.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

/**
 * Created by nejati on 29/01/2018.
 */

@Entity
@PrimaryKeyJoinColumn
public class Score extends feedback {

    @Column
    private long score;

    public Score(Date date, User creator, long score) {
        super(date, creator);
        this.score = score;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean AddScore(){
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

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
