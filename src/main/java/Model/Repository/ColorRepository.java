package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Color;

public class ColorRepository {

    public static boolean addIfNotExistName(Color color){
        String key = "name";
        String value = color.getName();
        return Hibernate.addIfNotExist(color,key,value);
    }
}
