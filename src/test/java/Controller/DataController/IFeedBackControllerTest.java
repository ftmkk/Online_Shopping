package Controller.DataController;

import Model.Entities.Feedback.Comment;
import Model.Entities.Feedback.FeedbackCollection;
import Model.Entities.ProductInfo.*;
import Model.Entities.UserInfo.Profile;
import Model.Entities.UserInfo.User;
import Model.Repository.FeedbackCollectionRepository;
import Model.Repository.FeedbackRepository;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by macintosh on 2/3/18.
 */

public class IFeedBackControllerTest extends TestCase {

    public void test_addCommentToProduct(){
        FeedbackController feedbackController = new FeedbackController();

        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));


        Product p1 = new Product(
                "p111",
                "P11",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p11!",
                91992,
                93,
                null,
                "THis is review of product p11!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L,
                new FeedbackCollection());

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        Date date = new Date();
        Comment comment = new Comment(date,user,"first Comment","this is my comment for product. this is amazing and low price");


        FeedbackCollectionRepository.addComment(p1.getFeedbackCollection(),comment);
        //assertEquals();
    }

    public void test_removeCommentOfProduct(){
        FeedbackController feedbackController = new FeedbackController();

        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));


        Product p1 = new Product(
                "p111",
                "P11",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p11!",
                91992,
                93,
                null,
                "THis is review of product p11!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L,
                new FeedbackCollection());

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        Date date = new Date();
        Comment comment = new Comment(date,user,"first Comment","this is my comment for product. this is amazing and low price");


        FeedbackRepository.remove(comment);
        //assertEquals();
    }

    public void test_modifyCommentOfProduct(){
        FeedbackController feedbackController = new FeedbackController();

        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        attrL1.add(new Attribute("screen size","1.2 inch",attrG));
        List<Color> colors1 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));


        Product p1 = new Product(
                "p111",
                "P11",
                10000000L,
                ProductStatus.AVAILABLE,
                3,
                "THis is product p11!",
                91992,
                93,
                null,
                "THis is review of product p11!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L,
                new FeedbackCollection());

        User user = new User(
                "Fatemeh",
                "123123",
                new Profile(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        Date date = new Date();
        Comment comment = new Comment(date,user,"first Comment","this is my comment for product. this is amazing and low price");


        FeedbackRepository.modify(comment);
        //assertEquals();
    }


}
