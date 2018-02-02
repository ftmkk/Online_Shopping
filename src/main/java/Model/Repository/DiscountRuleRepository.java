package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.Discount.DiscountRule;
import Model.Entities.ProductInfo.Product;

public class DiscountRuleRepository {

    public static boolean addIfNotExistName(DiscountRule discountRule){
        String key = "name";
        String value = discountRule.getName();
        boolean result = Hibernate.addIfNotExist(discountRule,key,value);
        DiscountRule g = (DiscountRule) Hibernate.getByKey(discountRule.getClass(),key,value);
        discountRule.setId(g.getId());
        return result;
    }


    public static boolean addProductInDiscountRuleIfNotExist(DiscountRule discountRule, Product product){
        if(!discountRule.hasProductInProductList(product)){
            discountRule.getProducts().add(product);
            Hibernate.update(discountRule);
            return true;
        }
        Hibernate.update(discountRule);
        return false;
    }

    public static boolean removeProductFromDiscountRuleIfExist(DiscountRule discountRule, Product product){
        if(discountRule.hasProductInProductList(product)){
            discountRule.getProducts().add(product);
            Hibernate.update(discountRule);
            return true;
        }
        Hibernate.update(discountRule);
        return false;
    }

    public static void modify(DiscountRule discountRule){
        Hibernate.update(discountRule);
    }

}
