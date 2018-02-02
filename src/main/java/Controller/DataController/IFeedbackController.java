package Controller.DataController;

import Model.Entities.Feedback.Answer;
import Model.Entities.Feedback.Comment;
import Model.Entities.Feedback.Question;
import Model.Entities.Feedback.Score;
import Model.Entities.ProductInfo.Product;

public interface IFeedbackController {
    void addCommentToProduct(Product product, Comment comment);

    void addScoreToProduct(Product product, Score score);

    void addQuestionToProduct(Product product, Question question);

    void addAnswerToQuestionInProduct(Question question, Answer answer);
}
