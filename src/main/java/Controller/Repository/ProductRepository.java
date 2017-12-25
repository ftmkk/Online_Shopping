package Controller.Repository;

import Model.Hibernate;
import Model.ProductModel.Attribute;
import Model.ProductModel.Color;
import Model.ProductModel.Product;

import java.util.List;

public class ProductRepository implements IProductRepository {

    public boolean addProduct(Product product){

        //SET BRAND
        product.getBrand().addIfNotExistName();

        //SET ATTRIBUTES
        for(Attribute attribute : product.getAttributes()){
            attribute.getAttributeGroup().addIfNotExistName();
            System.out.println("G:"+attribute.getAttributeGroup().getId());
        }

        //SET COLORS
        for(Color color : product.getColors()){
            color.addIfNotExistName();
        }

        //SET GUARANTY
        product.getGuaranty().addIfNotExistName();


        //SET PRODUCT
        return product.addIfNotExistName();
    }

    public Product getProductById(Integer id){
        return (Product) Hibernate.getById(Product.class,id);
    }


    public List<Product> getProducts(){
        return (List<Product>)(Object) Hibernate.getAll(Product.class);
    }
}
