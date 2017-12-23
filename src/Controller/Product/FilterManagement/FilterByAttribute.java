package Controller.Product.FilterManagement;

import Model.Product.AttributeManagement.Attribute;
import Model.Product.AttributeManagement.AttributeRepository;
import Model.Product.ProductManagement.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterByAttribute extends OptionalFilter{

    private FilterProducts filterProducts;
    private List<Attribute> attributes;

    public FilterByAttribute(FilterProducts filterProducts, List<Attribute> attributes) {
        this.filterProducts = filterProducts;
        this.attributes = attributes;
    }

    @Override
    public List<Product> filter() {
        List<Product> result = new ArrayList<>();
        List<Product> products = filterProducts.filter();

        HashMap<String, List<Object>> titleValueMap = new HashMap<>();
        for(Attribute attribute : attributes){
            String title = attribute.getTitle();
            Object value = attribute.getValue();
            if(!titleValueMap.containsKey(title)){
                titleValueMap.put(title, new ArrayList<>());
            }
            titleValueMap.get(title).add(value);
        }

        for(Product product : products){
            AttributeRepository attrR = product.getAttributes();
            boolean add = true;
            for(String title : titleValueMap.keySet()) {
                if(!titleValueMap.get(title).contains(attrR.getValueByTitle(title))){
                    add = false;
                }
            }
            if(add){
                result.add(product);
            }
        }
        return result;
    }
}
