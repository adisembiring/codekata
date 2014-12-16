package com.learnkata.test.BuyXForYFreeDiscountTest;

import com.learnkata.kata01.BuyXForYFreeDiscount;
import com.learnkata.test.ShopingCartContext;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class BuyXForYFreeDiscountContext extends ShopingCartContext {
    protected final BuyXForYFreeDiscount pringlesDiscount;

    public BuyXForYFreeDiscountContext() {
        pringlesDiscount = new BuyXForYFreeDiscount(1, "Buy 2 Get 1 Free", pepsi, 2, 1);
        cart.addDiscountPolicy(pringlesDiscount);
    }
}
