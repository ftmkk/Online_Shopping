package Model.Product.AttributeManagement;

import java.util.List;

public class AttributeRepository {

    private List<AttributeGroup> attributeGroups;

    public Object getValueByTitle(String title){
        for(AttributeGroup attributeGroup : attributeGroups){
            for(Attribute attribute : attributeGroup.getAttributes()){
                if(attribute.getTitle().equals(title)){
                    return attribute.getValue();
                }
            }
        }
        return null;
    }

}
