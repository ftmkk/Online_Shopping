package Model.ProductModel;

import Model.Hibernate;

import javax.persistence.*;

@Entity
public class AttributeGroup {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String persianName;

    public AttributeGroup(String name, String persianName) {
        this.name = name;
        this.persianName = persianName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeGroup() {
    }

    public boolean addIfNotExistName(){
        String key = "name";
        String value = this.getName();
        boolean result = Hibernate.addIfNotExist(this,key,value);
        AttributeGroup g = (AttributeGroup) Hibernate.getByKey(this.getClass(),key,value);
        this.setId(g.getId());
        return result;
    }

    @Override
    public String toString() {
        return "AttributeGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persianName='" + persianName + '\'' +
                '}';
    }
}
