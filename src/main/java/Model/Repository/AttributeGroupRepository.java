package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.ProductInfo.AttributeGroup;

public class AttributeGroupRepository {

    public static boolean addIfNotExistName(AttributeGroup attributeGroup){
        String key = "name";
        String value = attributeGroup.getName();
        boolean result = Hibernate.addIfNotExist(attributeGroup,key,value);
        AttributeGroup g = (AttributeGroup) Hibernate.getByKey(attributeGroup.getClass(),key,value);
        attributeGroup.setId(g.getId());
        return result;
    }




}
