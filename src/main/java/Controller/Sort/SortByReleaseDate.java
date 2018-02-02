package Controller.Sort;

import Model.ProductModel.ProductInfo.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByReleaseDate implements SortProducts {

    private List<Product> products;
    private boolean isAsc;

    public SortByReleaseDate(List<Product> products, boolean isAsc) {
        this.products = products;
        this.isAsc = isAsc;
    }

    @Override
    public List<Product> sort() {

        Collections.sort(products, new Comparator<Product>(){
            public int compare(Product o1, Product o2){
                if(isAsc)
                    return o1.getReleaseDate().compareTo(o2.getReleaseDate());
                else
                    return o2.getReleaseDate().compareTo(o1.getReleaseDate());
            }
        });

        return products;
    }
}
