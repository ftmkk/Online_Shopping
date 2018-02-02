package Controller.DataController;

import Model.Entities.Discount.DiscountRule;
import Model.Entities.ProductInfo.Product;
import Model.Repository.DiscountRuleRepository;

public class DiscountController implements IDiscountController{

    @Override
    public boolean addDiscountRule(DiscountRule discountRule){
        return DiscountRuleRepository.addIfNotExistName(discountRule);
    }

    @Override
    public boolean addProductToDiscountRule(DiscountRule discountRule, Product product){
        return DiscountRuleRepository.addProductInDiscountRuleIfNotExist(discountRule, product);
    }

    @Override
    public boolean removeProductFromDiscountRule(DiscountRule discountRule, Product product){
        return DiscountRuleRepository.removeProductFromDiscountRuleIfExist(discountRule, product);
    }

    @Override
    public void modifyDiscountRule(DiscountRule discountRulet){
        DiscountRuleRepository.modify(discountRulet);
    }
}
