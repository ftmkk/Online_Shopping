package Model.Repository;

import Model.DatabaseOperations.Elasticsearch;
import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.ProductInfo.Product;

import java.net.UnknownHostException;
import java.util.List;

public class ProductRepository {

    public static boolean addIfNotExistName(Product product){
        String key = "name";
        String value = product.getName();
        boolean result = Hibernate.addIfNotExist(product,key,value);
        Product g = (Product) Hibernate.getByKey(product.getClass(),key,value);
        product.setId(g.getId());
        return result;
    }

    public static Product getByName(String name) {
        return (Product) Hibernate.getByKey(Product.class,"name",name);
    }

    public static Product getById(Integer id){
        return (Product) Hibernate.getById(Product.class,id);
    }

    public static List<Product> getAll(){
        return (List<Product>)(Object) Hibernate.getAll(Product.class);
    }

    public void addToElastic(Product product) throws UnknownHostException {
        Elasticsearch.add(product);
    }

}
