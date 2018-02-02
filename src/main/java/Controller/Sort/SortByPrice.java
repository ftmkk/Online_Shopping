package Controller.Sort;

import Model.Entities.ProductInfo.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByPrice implements SortProducts {

    private List<Product> products;
    private boolean isAsc;

    public SortByPrice(List<Product> products, boolean isAsc) {
        this.products = products;
        this.isAsc = isAsc;
    }

    @Override
    public List<Product> sort() {

        Collections.sort(products, new Comparator<Product>(){
            public int compare(Product o1, Product o2){
                if(o1.getPrice() == o2.getPrice())
                    return 0;
                if(isAsc)
                    return o1.getPrice() < o2.getPrice() ? -1 : 1;
                else
                    return o1.getPrice() > o2.getPrice() ? -1 : 1;
            }
        });

        return products;
    }
}
