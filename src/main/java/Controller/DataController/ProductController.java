package Controller.DataController;

import Model.ProductModel.ProductInfo.Attribute;
import Model.ProductModel.ProductInfo.AttributeGroup;
import Model.ProductModel.ProductInfo.Color;
import Model.ProductModel.ProductInfo.Product;
import Model.Repository.*;

import java.util.List;

public class ProductController implements IProductController {

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

    public Product getProductById(Integer id){
        return ProductRepository.getById(id);
    }

    public Product getProductByName(String name) {
        return ProductRepository.getByName(name);
    }

    public List<Product> getProducts() {
        return ProductRepository.getAll();
    }
}
