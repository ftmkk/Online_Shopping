package Model.Product.AttributeManagement;

import java.util.List;

public class MultiValueAttribute extends Attribute {

    private List<String> value;

    @Override
    public Object getValue() {
        return value;
    }
}
