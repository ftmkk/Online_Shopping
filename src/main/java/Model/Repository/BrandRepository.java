package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.ProductInfo.Brand;

public class BrandRepository {

    public static boolean addIfNotExistName(Brand brand){
        String key = "name";
        String value = brand.getName();
        boolean result = Hibernate.addIfNotExist(brand,key,value);
        Brand b = (Brand) Hibernate.getByKey(brand.getClass(),key,value);
        brand.setId(b.getId());
        return result;
    }
}
