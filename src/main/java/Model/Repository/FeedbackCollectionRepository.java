package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.Feedback.Comment;
import Model.Entities.Feedback.FeedbackCollection;
import Model.Entities.Feedback.Question;
import Model.Entities.Feedback.Score;

public class FeedbackCollectionRepository {

    public static void addComment(FeedbackCollection feedbackCollection, Comment comment){
        feedbackCollection.getComments().add(comment);
        Hibernate.update(feedbackCollection);
    }

    public static void addScore(FeedbackCollection feedbackCollection, Score score){
        feedbackCollection.getScores().add(score);
        Hibernate.update(feedbackCollection);
    }

    public static void addQuestion(FeedbackCollection feedbackCollection, Question question){
        feedbackCollection.getQuestions().add(question);
        Hibernate.update(feedbackCollection);
    }

}
