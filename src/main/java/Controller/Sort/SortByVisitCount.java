package Controller.Sort;

import Model.ProductModel.ProductInfo.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByVisitCount implements SortProducts{

    private List<Product> products;
    private boolean isAsc;

    public SortByVisitCount(List<Product> products, boolean isAsc) {
        this.products = products;
        this.isAsc = isAsc;
    }

    @Override
    public List<Product> sort() {

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
