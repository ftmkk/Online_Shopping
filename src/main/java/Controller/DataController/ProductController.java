package Controller.DataController;

import Model.ProductModel.Attribute;
import Model.ProductModel.Color;
import Model.ProductModel.Product;

import java.util.List;

public class ProductController implements IProductController {

    public boolean addProduct(Product product){

        //SET BRAND
        product.getBrand().addIfNotExistName();

        //SET ATTRIBUTES
        for(Attribute attribute : product.getAttributes()){
            attribute.getAttributeGroup().addIfNotExistName();
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
        return Product.getById(id);
    }

    public Product getProductByName(String name) {
        return Product.getByName(name);
    }

    public List<Product> getProducts() {
        return Product.getAll();
    }
}
