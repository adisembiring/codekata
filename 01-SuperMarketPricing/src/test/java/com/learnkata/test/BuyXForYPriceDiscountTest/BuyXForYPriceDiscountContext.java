package com.learnkata.test.BuyXForYPriceDiscountTest;

import com.learnkata.kata01.BuyXForYPriceDiscount;
import com.learnkata.test.ShopingCartContext;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class BuyXForYPriceDiscountContext extends ShopingCartContext {
    protected final BuyXForYPriceDiscount pringlesDiscount;

    public BuyXForYPriceDiscountContext() {
        pringlesDiscount = new BuyXForYPriceDiscount(1, "Buy 3 For 40000", pringles, 3, 40000);
        cart.addDiscountPolicy(pringlesDiscount);
    }
}
