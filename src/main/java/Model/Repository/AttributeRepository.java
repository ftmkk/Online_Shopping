package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.ProductInfo.Attribute;

public class AttributeRepository {

    public void add(Attribute attribute){
        Hibernate.add(attribute);
    }
}
