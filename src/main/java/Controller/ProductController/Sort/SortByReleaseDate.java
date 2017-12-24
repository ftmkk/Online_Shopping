package Controller.ProductController.Sort;

import Model.ProductModel.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByReleaseDate implements SortProducts {
    @Override
    public List<Product> sort(List<Product> products , final boolean isAsc) {

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
