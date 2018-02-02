package Controller.Filter;

import Model.Entities.ProductInfo.Attribute;
import Model.Entities.ProductInfo.AttributeType;
import Model.Entities.ProductInfo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<AttributeType, List<Attribute>> attributeTypeMap = new HashMap<>();
        for(Attribute attribute : attributes){
            AttributeType attributeType = attribute;
            if(!attributeTypeMap.containsKey(attributeType)){
                attributeTypeMap.put(attributeType, new ArrayList<Attribute>());
            }
            attributeTypeMap.get(attributeType).add(attribute);
        }

        for(Product product : products){
            Map<AttributeType, Attribute> productAttributeTypeMap = new HashMap<>();
            for(Attribute attribute : product.getAttributes()){
                productAttributeTypeMap.put((AttributeType) attribute, attribute);
            }
            boolean add = true;
            for(AttributeType attributeType : attributeTypeMap.keySet()) {

                List<Attribute> possibleAttribute = attributeTypeMap.get(attributeType);
                List<String> possibleValues = new ArrayList<>();
                for(Attribute attribute : possibleAttribute){
                    possibleValues.add(attribute.getValue());
                }
                Attribute productAttribute = productAttributeTypeMap.get(attributeType);
                String productValue = productAttribute.getValue();
                if(!possibleValues.contains(productValue)){
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
