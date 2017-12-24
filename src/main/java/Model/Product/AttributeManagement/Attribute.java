package Model.Product.AttributeManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attribute<Object> {

    @Id
    @Column
    @GeneratedValue(generator = "increment")
    private Integer id;
    @Column
    private String title;
    @Column
    private Object value;

    public Attribute(Integer id, String title, Object value) {
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

    public void setValue(Object value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public Object getValue() {
        return value;
    }

    public boolean equals(Attribute attribute){
        return this.title.equals(attribute.getTitle());
    }
}
