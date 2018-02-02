package Controller.DataController;


import Model.Entities.Feedback.Answer;
import Model.Entities.Feedback.Comment;
import Model.Entities.Feedback.Question;
import Model.Entities.Feedback.Score;
import Model.Entities.ProductInfo.Product;
import Model.Repository.FeedbackCollectionRepository;
import Model.Repository.FeedbackRepository;
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


    @Override
    public boolean removeComment(Comment comment){
        return FeedbackRepository.remove(comment);
    }

    @Override
    public boolean removeScore(Score score){
        return FeedbackRepository.remove(score);
    }

    @Override
    public boolean removeQuestion(Question question){
        return FeedbackRepository.remove(question);
    }

    @Override
    public boolean removeAnswer(Answer answer){
        return FeedbackRepository.remove(answer);
    }


    @Override
    public boolean modifyComment(Comment comment){
        return FeedbackRepository.modify(comment);
    }

    @Override
    public boolean modifyScore(Score score){
        return FeedbackRepository.modify(score);
    }

    @Override
    public boolean modifyQuestion(Question question){
        return FeedbackRepository.modify(question);
    }

    @Override
    public boolean modifyAnswer(Answer answer){
        return FeedbackRepository.modify(answer);
    }


}
