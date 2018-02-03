package Controller.Recommendation;

import Model.Entities.Categorization.Category;
import Model.Entities.ProductInfo.Product;
import Model.Entities.UserInfo.User;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.jar.Pack200;

/**
 * Created by nejati on 03/02/2018.
 */
public abstract class RecommendationManagment {

    private List<Category> categories;
    private int numberForSeggest;

    abstract public Category recommend(User user);

    public List<Product> suggestProduct(Category category){
        Random rand = new Random();

        int numberOfElements = 2;
        List<Product> productList = null;

        for (int i = 0; i < this.numberForSeggest; i++) {
            int randomIndex = rand.nextInt(category.getProducts().size());
            productList.add(category.getProducts().get(randomIndex));
            this.categories.remove(randomIndex);
        }

        return productList;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getNumberForSeggest() {
        return numberForSeggest;
    }

    public void setNumberForSeggest(int numberForSeggest) {
        this.numberForSeggest = numberForSeggest;
    }
}
