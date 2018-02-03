package Controller.Recommendation;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;
import Model.Entities.UserInfo.User;
import Model.Entities.UserInfo.View;
import Model.Repository.CategoryRepository;
import Model.Repository.ViewRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by nejati on 03/02/2018.
 */
public class RecommendBaseFreq extends RecommendationManagment{

    public Category recommend(User user){
        List<View> views = ViewRepository.getByProperty(user);

        for (View v:views){
            Product product = v.getProduct();
            Category category = CategoryRepository.getCategoryByContent(product);
            if(!this.getCategories().contains(category))
                this.getCategories().add(category);
        }


        Map<Category, Integer> map = new HashMap<Category, Integer>();

        for(int i=0; i< this.getCategories().size(); i++) {

            Integer frequency = map.get(getCategories().get(i));
            if(frequency == null) {
                map.put(getCategories().get(i), 1);
            } else {
                map.put(getCategories().get(i), frequency+1);
            }
        }

        Category mostCommonKey = null;
        int maxValue = -1;
        for(Map.Entry<Category, Integer> entry: map.entrySet()) {

            if(entry.getValue() > maxValue) {
                mostCommonKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        this.suggestProduct(mostCommonKey);

        return mostCommonKey;
    }

}
