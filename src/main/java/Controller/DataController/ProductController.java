package Controller.DataController;

import Model.Entities.ProductInfo.Attribute;
import Model.Entities.ProductInfo.AttributeGroup;
import Model.Entities.ProductInfo.Color;
import Model.Entities.ProductInfo.Product;
import Model.Repository.*;

import java.util.List;

public class ProductController implements IProductController {

    @Override
    public boolean addProduct(Product product){

        //SET BRAND
        BrandRepository.addIfNotExistName(product.getBrand());


        //SET ATTRIBUTES
        for(Attribute attribute : product.getAttributes()){
            AttributeGroupRepository.addIfNotExistName(attribute.getAttributeGroup());
        }

        //SET COLORS
        for(Color color : product.getColors()){
            ColorRepository.addIfNotExistName(color);
        }

        //SET GUARANTY
        GuarantyRepository.addIfNotExistName(product.getGuaranty());


        //SET PRODUCT
        return ProductRepository.addIfNotExistName(product);
        //product.addToElastic();
        //if(added){

       // }
        //return added;
    }

    @Override
    public boolean removeProduct(Product product){
        return ProductRepository.removeIfExistName(product);
    }

    @Override
    public Product getProductById(Integer id){
        return ProductRepository.getById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return ProductRepository.getByName(name);
    }

    @Override
    public List<Product> getProducts() {
        return ProductRepository.getAll();
    }
}
