package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.ProductInfo.Guaranty;

public class GuarantyRepository {

    public static boolean addIfNotExistName(Guaranty guaranty){
        String key = "name";
        String value = guaranty.getName();
        boolean result = Hibernate.addIfNotExist(guaranty,key,value);
        Guaranty g = (Guaranty) Hibernate.getByKey(guaranty.getClass(),key,value);
        guaranty.setId(g.getId());
        return result;
    }
}
