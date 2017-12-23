package Model.Product.AttributeManagement;

import java.util.List;

public class AttributeGroup {

    private String title;
    private List<Attribute> attributes;
    private Integer order;

    public AttributeGroup(String title, List<Attribute> attributes, Integer order) {
        this.title = title;
        this.attributes = attributes;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Integer getOrder() {
        return order;
    }
}
