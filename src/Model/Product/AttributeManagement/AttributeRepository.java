package Model.Product.AttributeManagement;

import java.util.List;

public class AttributeRepository {

    private List<AttributeGroup> attributeGroups;

    public void addAttributeGroup(AttributeGroup attributeGroup){
        attributeGroups.add(attributeGroup);
    }

    public AttributeGroup getAttributeGroupByTitle(String title){
        for(AttributeGroup attributeGroup : attributeGroups){
            if(attributeGroup.getTitle().equals(title)){
                return attributeGroup;
            }
        }
        return null;
    }

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
