package Controller.DataController;


import Model.Entities.Feedback.Answer;
import Model.Entities.Feedback.Comment;
import Model.Entities.Feedback.Question;
import Model.Entities.Feedback.Score;
import Model.Entities.ProductInfo.Product;
import Model.Repository.FeedbackCollectionRepository;
import Model.Repository.QuestionRepository;

public class FeedbackController implements IFeedbackController {


    @Override
    public void addCommentToProduct(Product product, Comment comment){
        FeedbackCollectionRepository.addComment(product.getFeedbackCollection(), comment);
    }

    @Override
    public void addScoreToProduct(Product product, Score score){
        FeedbackCollectionRepository.addScore(product.getFeedbackCollection(), score);
    }

    @Override
    public void addQuestionToProduct(Product product, Question question){
        FeedbackCollectionRepository.addQuestion(product.getFeedbackCollection(), question);
    }

    @Override
    public void addAnswerToQuestionInProduct(Question question, Answer answer){
        QuestionRepository.addAnswer(question, answer);
    }


}
