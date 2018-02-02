package Controller.DataController;

import Model.Entities.Discount.DiscountRule;
import Model.Entities.ProductInfo.Product;

public interface IDiscountController {

    boolean addDiscountRule(DiscountRule discountRule);

    boolean addProductToDiscountRule(DiscountRule discountRule, Product product);

    boolean removeProductFromDiscountRule(DiscountRule discountRule, Product product);

    void modifyDiscountRule(DiscountRule discountRulet);
}
