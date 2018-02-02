package Model.Entities.ProductInfo;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Inheritance
public class AttributeType {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String title;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private AttributeGroup attributeGroup;

    public AttributeType() {
    }

    public AttributeType(String title) {
        this.title = title;
    }

    public AttributeType(String title, AttributeGroup attributeGroup) {
        this.title = title;
        this.attributeGroup = attributeGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AttributeGroup getAttributeGroup() {
        return attributeGroup;
    }

    public void setAttributeGroup(AttributeGroup attributeGroup) {
        this.attributeGroup = attributeGroup;
    }


    @Override
    public String toString() {
        return "AttributeType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", attributeGroup=" + attributeGroup +
                '}';
    }
}
