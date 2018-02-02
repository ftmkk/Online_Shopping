package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.Categorization.Category;
import Model.ProductModel.Categorization.Content;

public class CategoryRepository {

    public static boolean addIfNotExistName(Category category){
        String key = "name";
        String value = category.getName();
        boolean result = Hibernate.addIfNotExist(category,key,value);
        Category g = (Category) Hibernate.getByKey(category.getClass(),key,value);
        category.setId(g.getId());
        return result;
    }

    public static Category getByName(String name) {
        return (Category) Hibernate.getByKey(Category.class,"name",name);
    }


    public static boolean addContentIfNotExist(Category category, Content content){
        if(!category.hasContent(content)){
            category.getContents().add(content);
            Hibernate.update(category);
            return true;
        }
        Hibernate.update(category);
        return false;
    }
}
