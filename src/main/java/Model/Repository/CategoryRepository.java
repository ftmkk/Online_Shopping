package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.Categorization.Category;
import Model.Entities.Categorization.Content;
import Model.Entities.ProductInfo.Product;

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

    public static boolean removeIfExistName(Category category) {
        String key = "name";
        String value = category.getName();
        boolean result = Hibernate.removeIfExist(category,key,value);
        Category g = (Category) Hibernate.getByKey(category.getClass(),key,value);
        category.setId(g.getId());
        return result;
    }

    public static boolean removeContentIfExist(Category category, Content content) {
        if(category.hasContent(content)){
            category.getContents().add(content);
            Hibernate.update(category);
            return true;
        }
        Hibernate.update(category);
        return false;
    }
}
