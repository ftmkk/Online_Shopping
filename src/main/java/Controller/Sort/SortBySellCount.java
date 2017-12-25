package Controller.Sort;

import Model.ProductModel.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBySellCount implements SortProducts {
    @Override
    public List<Product> sort(List<Product> products , final boolean isAsc) {

        Collections.sort(products, new Comparator<Product>(){
            public int compare(Product o1, Product o2){
                if(o1.getSellCount() == o2.getSellCount())
                    return 0;
                if(isAsc)
                    return o1.getSellCount() < o2.getSellCount() ? -1 : 1;
                else
                    return o1.getSellCount() > o2.getSellCount() ? -1 : 1;
            }
        });

        return products;
    }
}
