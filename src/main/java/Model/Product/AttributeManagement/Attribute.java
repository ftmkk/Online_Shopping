package Model.Product.AttributeManagement;

import javax.persistence.*;

@Entity
public class Attribute {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;
    @Column
    private String value;

    public Attribute(Integer id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Attribute() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(Attribute attribute){
        return this.title.equals(attribute.getTitle());
    }
}
