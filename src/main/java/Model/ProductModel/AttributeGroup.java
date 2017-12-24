package Model.ProductModel;

import javax.persistence.*;

@Entity
public class AttributeGroup {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn
    private AttributeGroup nextAttributeGroup;

    public AttributeGroup(String title, AttributeGroup nextAttributeGroup) {
        this.title = title;
        this.nextAttributeGroup = nextAttributeGroup;
    }

    public AttributeGroup() {
    }
}
