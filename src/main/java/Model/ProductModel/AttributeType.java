package Model.ProductModel;

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
    private AttributeType nextAttribute;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    private AttributeGroup attributeGroup;


    public AttributeType() {
    }

    public AttributeType(String title, AttributeType nextAttribute, AttributeGroup attributeGroup) {
        this.title = title;
        this.nextAttribute = nextAttribute;
        this.attributeGroup = attributeGroup;
    }
}
