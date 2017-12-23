package Model.Product.ProductManagement;

import Model.Product.AttributeManagement.AttributeRepository;

import java.util.List;

public class Category implements AbstractProduct{

    private String name;
    private String persianName;
    private List<AbstractProduct> subcategories;
    private List<Brand> brands;
    private AttributeRepository possibleAttrs;

}
