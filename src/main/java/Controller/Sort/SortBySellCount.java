package Controller.Sort;

import Model.ProductModel.ProductInfo.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBySellCount implements SortProducts {

    private List<Product> products;
    private boolean isAsc;

    public SortBySellCount(List<Product> products, boolean isAsc) {
        this.products = products;
        this.isAsc = isAsc;
    }

    @Override
    public List<Product> sort() {

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
