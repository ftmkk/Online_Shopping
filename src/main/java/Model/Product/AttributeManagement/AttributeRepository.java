package Model.Product.AttributeManagement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeRepository {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    @OneToMany
    private List<AttributeGroup> attributeGroups;

    public AttributeRepository() {
        attributeGroups = new ArrayList<>();
    }

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
