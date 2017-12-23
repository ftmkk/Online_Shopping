package Model.Product.AttributeManagement;

public class Attribute<Object> {

    private String title;
    private Object value;

    public Attribute(String title, Object value) {
        this.title = title;
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
