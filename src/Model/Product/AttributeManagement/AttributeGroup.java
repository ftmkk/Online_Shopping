package Model.Product.AttributeManagement;

import java.util.*;

public class AttributeGroup {

    private String title;
    private Map<Integer, Attribute> attributes;

    public AttributeGroup(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Attribute> getAttributes() {
        TreeMap<Integer, Attribute> sorted = new TreeMap<>(attributes);
        return (List<Attribute>) sorted.values();
    }

    public boolean equals(AttributeGroup attributeGroup){
        return attributeGroup.title.equals(this.title);
    }

    public void addAttribute(Attribute attribute){
        attributes.put(attributes.size(),attribute);
    }

    public boolean removeAttribute(Attribute attribute){
        Integer removedIndex = getIndex(attribute);
        if(removedIndex!=null){
            for(int i = removedIndex; i <= attributes.size() ; i++){
                attributes.put(i,attributes.get(i+1));
            }
            attributes.remove(attributes.size());
            return true;
        }
        return false;
    }

    public Integer getIndex(Attribute attribute){
        for(Integer index : attributes.keySet()){
            Attribute currentAttribute = attributes.get(index);
            if(currentAttribute.equals(attribute)){
                return index;
            }
        }
        return null;
    }
}
