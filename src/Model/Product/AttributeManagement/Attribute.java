package Model.Product.AttributeManagement;

public abstract class Attribute {

    private String title;
    private Integer order;

    public abstract Object getValue();

    public String getTitle() {
        return title;
    }

    public Integer getOrder() {
        return order;
    }
}
