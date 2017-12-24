package Controller.ProductController.SortManagement;

import Model.ProductModel.ProductManagement.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByVisitCount implements SortProducts{

    @Override
    public List<Product> sort(List<Product> products , final boolean isAsc) {

        Collections.sort(products, new Comparator<Product>(){
            public int compare(Product o1, Product o2){
                if(o1.getVisitCount() == o2.getVisitCount())
                    return 0;
                if(isAsc)
                    return o1.getVisitCount() < o2.getVisitCount() ? -1 : 1;
                else
                    return o1.getVisitCount() > o2.getVisitCount() ? -1 : 1;
            }
        });

        return products;
    }
}
