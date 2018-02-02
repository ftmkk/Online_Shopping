package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.Feedback.Answer;
import Model.Entities.Feedback.Question;

public class QuestionRepository {

    public static Question getById(Integer id){
        return (Question) Hibernate.getById(Question.class,id);
    }

    public static void addAnswer(Question question, Answer answer){
        question.getAnswers().add(answer);
    }

}
