package Model.Entities.ProductInfo;

import Model.DatabaseOperations.Hibernate;

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

    public Attribute(String title, String value, AttributeGroup attributeGroup) {
        super(title,  attributeGroup);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "value='" + value + '\'' +
                '}';
    }
}