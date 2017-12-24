package Model.ProductModel;

import javax.persistence.*;

@Entity
public class Attribute extends AttributeType{

    @Column
    private String value;

    public Attribute() {
    }

    public String getValue() {
        return value;
    }

    public Attribute(String value) {
        this.value = value;
    }

    public Attribute(String title, String value, AttributeGroup attributeGroup, AttributeType nextAttribute) {
        super(title, nextAttribute, attributeGroup);
        this.value = value;
    }
}
