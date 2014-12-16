package com.learnkata.test.MixDiscountTest;

import com.learnkata.kata01.BuyXForYFreeDiscount;
import com.learnkata.kata01.BuyXForYPriceDiscount;
import com.learnkata.test.ShopingCartContext;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class MixDiscountContext extends ShopingCartContext {
    protected final BuyXForYPriceDiscount pringlesDiscount;
    protected final BuyXForYFreeDiscount pepsiDiscount;

    public MixDiscountContext() {
        pringlesDiscount = new BuyXForYPriceDiscount(1, "Buy 3 For 40000", pringles, 3, 40000);
        cart.addDiscountPolicy(pringlesDiscount);

        pepsiDiscount = new BuyXForYFreeDiscount(2, "Buy 2 Get 1 Free", pepsi, 2, 1);
        cart.addDiscountPolicy(pepsiDiscount);
    }
}
