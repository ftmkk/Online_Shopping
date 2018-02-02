package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.Feedback.Feedback;

public class FeedbackRepository {

    public static boolean remove(Feedback feedback){
        try {
            Hibernate.delete(feedback);
            return true;
        }catch (Exception e){
            System.out.print(e.toString());
            return false;
        }
    }

    public static boolean modify(Feedback feedback){
        try {
            Hibernate.update(feedback);
            return true;
        }catch (Exception e){
            System.out.print(e.toString());
            return false;
        }
    }
}
