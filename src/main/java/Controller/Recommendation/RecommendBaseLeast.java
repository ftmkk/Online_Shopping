package Controller.Recommendation;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;
import Model.Entities.UserInfo.User;
import Model.Entities.UserInfo.View;
import Model.Repository.CategoryRepository;
import Model.Repository.ViewRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by nejati on 03/02/2018.
 */
public class RecommendBaseLeast extends RecommendationManagment {

    public Category recommend(User user){
        List<View> views = ViewRepository.getByProperty(user);
        Category result =null;

        for(int i=1;i<views.size() ; i++){
            Product product = views.get(i).getProduct();
            Category category = CategoryRepository.getCategoryByContent(product);
            if(views.get(i).getDate().getTime() < views.get(i-1).getDate().getTime()){
                result = category;
            }
        }

        this.suggestProduct(result);

        return result;
    }


}
