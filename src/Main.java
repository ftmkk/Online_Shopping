import Model.Product.ProductManagement.Brand;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Brand brand1 = new Brand(1,"Apple","apple");
        Brand brand2 = new Brand(1,"Apple","apple");

        List<Brand> brandList = new ArrayList<Brand>();
        brandList.add(brand2);

        System.out.printf(""+brand1.equals(brand2));

    }
}
